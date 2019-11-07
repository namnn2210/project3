package ginp14.project3.controller;

import ginp14.project3.model.Category;
import ginp14.project3.model.Product;
import ginp14.project3.service.CategoryService;
import ginp14.project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @PostMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "views/admin/add_category";
        }
        category.setStatus(true);
        categoryService.save(category);
        return "redirect:/admin/listCategories";
    }

    @PostMapping("/deleteCategory")
    public @ResponseBody String deleteCategory(@RequestBody int catId){
        Category category = categoryService.findById(catId);
        List<Product> products = productService.findAllByCategoryId(catId);
        for (Product product:products) {
            product.setStatus(false);
            productService.save(product);
        }
        category.setStatus(false);
        categoryService.save(category);
        return "false";
    }
}
