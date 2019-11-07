package ginp14.project3.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ginp14.project3.model.*;
import ginp14.project3.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;


    private List<Category> categories = null;

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "fragments/admin/master_layout";
    }

    @GetMapping("/listUsers")
    public String showListUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "views/admin/list_users";
    }

    @GetMapping("/listProducts")
    public String showListProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "views/admin/list_products";
    }

    @GetMapping("/listCategories")
    public String showListCategories(Model model) {
        categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "views/admin/list_categories";
    }

    @GetMapping("/listTeams")
    public String showListTeams(Model model) {
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        return "views/admin/list_teams";
    }

    @GetMapping("/listOrders")
    public String showListOrder(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders",orders);
        return "views/admin/list_orders";
    }

    @GetMapping("/orderDetail")
    public String showOrderDetail(@RequestParam("orderId") int id, Model model) {
        List<OrderDetail> orderDetails = orderDetailService.findByOrderId(id);
        model.addAttribute("orderId",id);
        model.addAttribute("orderDetails",orderDetails);
        return "views/admin/order_detail";
    }

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        Product product = new Product();
        List<Team> teams = teamService.findAll();
        categories = categoryService.findAll();
        model.addAttribute("teams", teams);
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "views/admin/add_product";
    }

    @GetMapping("/editProduct")
    public String showEditProductForm(@RequestParam("productId") int id, Model model) {
        Product product = productService.findById(id);
        categories = categoryService.findAll();
        List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
        model.addAttribute("categories", categories);
        model.addAttribute("product", product);
        return "views/admin/add_product";
    }

    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        User user = new User();
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "views/admin/add_user";
    }

    @GetMapping("/editUser")
    public String showEditUserForm(@RequestParam("userId") int id, Model model) {
        User user = userService.findById(id);
        List<Role> roles = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "views/admin/add_user";
    }

    @GetMapping("/addCategory")
    public String showAddCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "views/admin/add_category";
    }

    @GetMapping("/editCategory")
    public String showEditCategoryForm(@RequestParam("catId") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "views/admin/add_category";
    }

    @GetMapping("/addTeam")
    public String showAddTeamForm(Model model) {
        Team team = new Team();
        model.addAttribute("team",team);
        return "views/admin/add_team";
    }

    @GetMapping("/editTeam")
    public String showEditTeamForm(@RequestParam("teamId") int id, Model model) {
        Team team = teamService.findById(id);
        model.addAttribute("team", team);
        return "views/admin/add_team";
    }
}
