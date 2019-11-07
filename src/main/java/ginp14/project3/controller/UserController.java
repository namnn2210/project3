package ginp14.project3.controller;

import ginp14.project3.model.Order;
import ginp14.project3.model.OrderDetail;
import ginp14.project3.model.Role;
import ginp14.project3.model.User;
import ginp14.project3.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String showLogin(Model model) {
        User user = new User();
        model.addAttribute("categories", categoryService.findAllByStatus(true));
        model.addAttribute("user", user);
        return "views/user/login";
    }

    @GetMapping("/adminLogin")
    public String showAdminLogin(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "views/admin/login";
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("categories", categoryService.findAllByStatus(true));
        return "views/user/register";
    }

    @PostMapping("/userRegisterProcess")
    public String userRegisterProcess(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "views/user/register";
        }
        if (userService.isUserExisted(user.getUsername())) {
            model.addAttribute("usernameExist", true);
            return "views/user/register";
        } else if (userService.isEmailExisted(user.getEmail())) {
            model.addAttribute("emailExist", true);
            return "views/user/register";
        } else {
            if (user.getRole() == null) {
                Role role = roleService.findById(1);
                user.setRole(role);
            }
            user.setStatus(true);
            userService.saveUser(user);
        }
        return "redirect:/homepage";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Role> roles = roleService.findAll();
            model.addAttribute("roles", roles);
            return "views/admin/add_user";
        }
        if (user.getUsername() == null) {
            if (userService.isUserExisted(user.getUsername())) {
                List<Role> roles = roleService.findAll();
                model.addAttribute("roles", roles);
                model.addAttribute("usernameExist", true);
                return "views/admin/add_user";
            }
        }
        if (user.getEmail() == null) {
            if (userService.isEmailExisted(user.getEmail())) {
                List<Role> roles = roleService.findAll();
                model.addAttribute("roles", roles);
                model.addAttribute("emailExist", true);
                return "views/admin/add_user";
            }
        }
        userService.saveUser(user);

        return "redirect:/admin/listUsers";
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes
            attributes) {
        if (result.hasErrors()) {
            return "redirect:/profile";
        }
        userService.saveUser(user);
        attributes.addFlashAttribute("updateSucces", true);
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:login";
        }
        String username = principal.getName();
        User user = userService.findByUsername(username);
        model.addAttribute("categories", categoryService.findAllByStatus(true));
        model.addAttribute("user", user);
        return "views/user/profile";
    }

    @GetMapping("/orderHistory")
    public String showOrderHistory(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:login";
        }
        String username = principal.getName();
        User user = userService.findByUsername(username);
        List<Order> orders = orderService.findByUserId(user.getId());
        HashMap<Integer, List<OrderDetail>> maps = new HashMap<>();
        for (Order order : orders) {
            List<OrderDetail> orderDetails = orderDetailService.findByOrderId(order.getId());
            maps.put(order.getId(), orderDetails);
        }
        model.addAttribute("orders", orders);
        model.addAttribute("maps", maps);
        model.addAttribute("categories",categoryService.findAllByStatus(true));
        return "views/user/order_history";
    }
}
