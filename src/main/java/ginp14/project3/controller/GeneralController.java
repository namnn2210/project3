package ginp14.project3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/homepage")
    public String showHomepage() {
        return "views/index";
    }
}
