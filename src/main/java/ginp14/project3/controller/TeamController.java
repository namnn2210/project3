package ginp14.project3.controller;

import ginp14.project3.model.Product;
import ginp14.project3.model.Team;
import ginp14.project3.service.ProductService;
import ginp14.project3.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private ProductService productService;

    @PostMapping("/addTeam")
    public String addTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
        if (result.hasErrors()) {
            return "views/admin/add_team";
        }
        team.setStatus(true);
        teamService.save(team);
        return "redirect:/admin/listTeams";
    }

    @PostMapping("/deleteTeam")
    public @ResponseBody String deleteTeam(@RequestBody int teamId) {
        Team team = teamService.findById(teamId);
        List<Product> products = productService.findAllByTeamId(teamId);
        for (Product product:products) {
            product.setStatus(false);
            productService.save(product);
        }
        team.setStatus(false);
        teamService.save(team);
        return "false";
    }
}
