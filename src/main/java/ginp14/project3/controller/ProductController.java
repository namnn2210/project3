package ginp14.project3.controller;

import ginp14.project3.model.Product;
import ginp14.project3.service.CategoryService;
import ginp14.project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public String showAllProducts(Model model) {
        model.addAttribute("allProducts", productService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        return "views/product/allProducts";
    }

    @GetMapping("/detail")
    public String showProductDetail(@RequestParam int productId, Model model) {
        Product product = productService.findById(productId);
        model.addAttribute("product",product);
        model.addAttribute("products",productService.findAllByCategoryId(product.getCategory().getId()));
        model.addAttribute("categories",categoryService.findAll());
        return "views/product/product_detail";
    }

    @GetMapping("/category")
    public String showProductByCategory(@RequestParam int categoryId, Model model) {
        model.addAttribute("allProducts",productService.findAllByCategoryId(categoryId));
        model.addAttribute("categories",categoryService.findAll());
        return "views/product/allProducts";
    }
}


