package ginp14.project3.controller;

import ginp14.project3.model.CartItem;
import ginp14.project3.model.ProductCriteria;
import ginp14.project3.model.ShoppingCart;
import ginp14.project3.service.CategoryService;
import ginp14.project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/detail")
    public String showCartDetail(Model model, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            return "redirect:/cart/noitem";
        }
        model.addAttribute("categories", categoryService.findAll());
        return "views/product/cart";
    }

    @GetMapping("/noitem")
    private String showNoItemError(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "views/other/no_item_cart";
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
}
