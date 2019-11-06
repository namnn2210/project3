package ginp14.project3.controller;

import com.cloudinary.utils.ObjectUtils;
import ginp14.project3.config.CloudinaryConfig;
import ginp14.project3.model.*;
import ginp14.project3.service.CategoryService;
import ginp14.project3.service.ProductService;
import ginp14.project3.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private CloudinaryConfig cloudinary;

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            List<Category> categories = categoryService.findAll();
            List<Team> teams = teamService.findAll();
            model.addAttribute("teams",teams);
            model.addAttribute("categories",categories);
            return "views/admin/add_product";
        }
        else if(product.getUrl() == null) {
            if(file.isEmpty()) {
                model.addAttribute("message","No file uploaded. Product must have an image");
                List<Category> categories = categoryService.findAll();
                List<Team> teams = teamService.findAll();
                model.addAttribute("teams",teams);
                model.addAttribute("categories",categories);
                return "views/admin/add_product";
            }
            try {
                Map uploadResult = cloudinary.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
                String url = uploadResult.get("url").toString();
                product.setUrl(url);
                productService.save(product);
            } catch (IOException e){
                e.printStackTrace();
                model.addAttribute("message", "Sorry I can't upload that!");
            }
        }
        else {
            productService.save(product);
        }
        return "redirect:/admin/listProducts";
    }

    @GetMapping("/all")
    public String showAllProducts(Model model, @PageableDefault(size = 6) Pageable pageable) {
        model.addAttribute("allProducts", productService.findAll(pageable));
        model.addAttribute("categories", categoryService.findAll());
        return "views/product/allProducts";
    }

    @GetMapping("/detail")
    public String showProductDetail(@RequestParam int productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        model.addAttribute("products", productService.findAllByCategoryId(product.getCategory().getId()));
        model.addAttribute("categories", categoryService.findAll());
        return "views/product/product_detail";
    }

    @GetMapping("/category")
    public String showProductByCategory(@RequestParam int categoryId, Model model, @PageableDefault(size = 6) Pageable pageable) {
        model.addAttribute("allProducts", productService.findAllByCategoryId(categoryId, pageable));
        model.addAttribute("categories", categoryService.findAll());
        return "views/product/allProducts";
    }

    @PostMapping("/addToCart")
    public @ResponseBody
    ShoppingCart addToCartProcess(@RequestBody ProductCriteria productCriteria, HttpSession session) {
        ShoppingCart cart;
        List<CartItem> cartItems;
        Product product = productService.findById(productCriteria.getId());
        if (session.getAttribute("cart") == null) {
            cart = new ShoppingCart();
            cartItems = new ArrayList<>();
            cartItems.add(new CartItem(product, productCriteria.getQuantity(), productCriteria.getSize()));
            cart.setCartItem(cartItems);
            session.setAttribute("cart", cart);
            session.setAttribute("cartItem", cartItems);
        } else {
            cart = (ShoppingCart) session.getAttribute("cart");
            cartItems = (List<CartItem>) session.getAttribute("cartItem");
            int index = exists(productCriteria.getId(), productCriteria.getSize(), cart.getCartItem());
            if (index == -1) {
                cartItems.add(new CartItem(product, productCriteria.getQuantity(), productCriteria.getSize()));
                cart.setCartItem(cartItems);
            } else {
                int quantity = cart.getCartItem().get(index).getQuantity() + productCriteria.getQuantity();
                cart.getCartItem().get(index).setQuantity(quantity);
            }
        }
        cart.setTotalPrice(getTotalPrice(cart.getCartItem()));
        return cart;
    }

    private int exists(int id, String size, List<CartItem> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id && cart.get(i).getSize().equalsIgnoreCase(size)) {
                return i;
            }
        }
        return -1;
    }

    public static double getTotalPrice(List<CartItem> cart) {
        double totalPrice = 0.0;
        for (CartItem cartItem : cart) {
            totalPrice += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        return totalPrice;
    }
}


