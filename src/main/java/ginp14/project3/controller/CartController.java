package ginp14.project3.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import ginp14.project3.config.PaypalPaymentIntent;
import ginp14.project3.config.PaypalPaymentMethod;
import ginp14.project3.model.*;
import ginp14.project3.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private PaypalService paypalService;

    @Autowired
    HttpSession session;

    @Autowired
    private EmailService emailService;

    private static final String SUCCESS_URL = "/cart/checkout/success";
    private static final String CANCEL_URL = "/cart/checkout/cancel";

    private String checkoutName = "";
    private String checkoutAddress = "";
    private String checkoutPhone = "";

    @GetMapping("/detail")
    public String showCartDetail(Model model, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            return "redirect:/cart/noitem";
        }
        model.addAttribute("categories", categoryService.findAll());
        return "views/product/cart";
    }

    @GetMapping("/noitem")
    public String showNoItemError(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "views/other/no_item_cart";
    }

    @GetMapping("/ordersuccess")
    public String showOrderSuccess() {
        return "views/order/order_confirmation";
    }

    @PostMapping("/updateCart")
    public @ResponseBody
    ShoppingCart updateCart(@RequestBody List<ProductCriteria> productsCriteria, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        List<CartItem> cartItems = cart.getCartItem();
        for (ProductCriteria productCriteria : productsCriteria) {
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId() == productCriteria.getId() && cartItem.getSize().equalsIgnoreCase(productCriteria.getSize())) {
                    cartItem.setQuantity(productCriteria.getQuantity());
                }
            }
        }
        cart.setTotalPrice(ProductController.getTotalPrice(cart.getCartItem()));
        return cart;
    }

    @PostMapping("/removeCartProduct")
    public @ResponseBody
    ShoppingCart removeFromCart(@RequestBody ProductCriteria productCriteria, HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        List<CartItem> cartItems = cart.getCartItem();
        cartItems.removeIf(cartItem -> cartItem.getProduct().getId() == productCriteria.getId() && cartItem.getSize().equalsIgnoreCase(productCriteria.getSize()));
        cart.setTotalPrice(ProductController.getTotalPrice(cart.getCartItem()));
        return cart;
    }

    @GetMapping("/checkout")
    public String checkout(Principal principal, Model model) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        List<CartItem> cartItems = cart.getCartItem();
        String username = principal.getName();
        User user = userService.findByUsername(username);
        Order order = new Order();
        order.setUser(user);
        order.setShippingAddress(checkoutAddress);
        order.setShippingName(checkoutName);
        order.setShippingPhone(checkoutPhone);
        order.setTotalPrice(cart.getTotalPrice());
        orderService.save(order);
        for (CartItem item : cartItems) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(item.getProduct());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setSize(item.getSize());
            orderDetail.setItemTotalPrice(item.getQuantity() * item.getProduct().getPrice());
            orderDetailService.save(orderDetail);
        }
        //Send order confirmation
        try {
            String subject = "KitStore Order Confirmation";
            String templateFileName = "views/order/email_confirmation";
            Context context = new Context();
            emailService.sendEmail(user.getEmail(),subject,templateFileName,context);
        }
        catch (MessagingException ex) {
            ex.printStackTrace();
        }
        model.addAttribute("user",user);
        model.addAttribute("order",order);
        model.addAttribute("cartItems",cartItems);
        session.removeAttribute("cart");
        return "views/order/order_confirmation";
    }

    @PostMapping("/pay")
    public String pay(@RequestParam(required = false, name = "checkoutName") String checkoutName, @RequestParam(required = false, name = "checkoutAddress") String checkoutAddress, @RequestParam(required = false, name = "checkoutPhone") String checkoutPhone,HttpSession session, Principal principal, RedirectAttributes attributes) {
        if (principal == null) {
            return "redirect:/login";
        }
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        this.checkoutAddress = checkoutAddress;
        this.checkoutName = checkoutName;
        this.checkoutPhone = checkoutPhone;
        try {
            Payment payment = paypalService.createPayment(cart.getTotalPrice(), "USD", PaypalPaymentMethod.paypal, PaypalPaymentIntent.order, "http://localhost:8080" + CANCEL_URL, "http://localhost:8080" + SUCCESS_URL);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }
        } catch (PayPalRESTException ppex) {
            ppex.printStackTrace();
        }
        return "error";
    }

    @GetMapping("/checkout/cancel")
    public String cancelCheckout() {
        return "redirect:/cart/detail";
    }

    @GetMapping("/checkout/success")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                return "redirect:/cart/checkout";
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
