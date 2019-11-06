package ginp14.project3.controller;

import ginp14.project3.model.Category;
import ginp14.project3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "views/admin/add_category";
        }
        category.setStatus(true);
        categoryService.save(category);
        return "redirect:/admin/listCategories";
    }
}
