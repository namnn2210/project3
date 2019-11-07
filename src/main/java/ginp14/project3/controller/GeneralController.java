package ginp14.project3.controller;

import ginp14.project3.service.CategoryService;
import ginp14.project3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/homepage")
    public String showHomepage(Model model) {
        model.addAttribute("categories", categoryService.findAllByStatus(true));
        model.addAttribute("products", productService.findAllByStatus(true));
        return "views/index";
    }

    @GetMapping("/403")
    public String showForbidden() {
        return "views/other/page_error_403";
    }
}
