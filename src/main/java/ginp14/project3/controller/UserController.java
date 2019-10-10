package ginp14.project3.controller;

import ginp14.project3.model.User;
import ginp14.project3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.Bidi;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLogin(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "views/user/login";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "views/user/register";
    }

    @PostMapping("/userRegisterProcess")
    public String userRegisterProcess(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "views/user/register";
        }
        if(userService.isUserExisted(user.getUsername())) {
            model.addAttribute("usernameExist",true);
            return "views/user/register";
        }
        else if(userService.isEmailExisted(user.getEmail())) {
            model.addAttribute("emailExist",true);
            return "views/user/register";
        }
        else {
            userService.saveUser(user);
        }
        return "redirect:/homepage";
    }
}
