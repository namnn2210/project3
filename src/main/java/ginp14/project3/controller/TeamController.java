package ginp14.project3.controller;

import ginp14.project3.model.Team;
import ginp14.project3.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/addTeam")
    public String addTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {
        if (result.hasErrors()) {
            return "views/admin/add_team";
        }
        team.setStatus(true);
        teamService.save(team);
        return "redirect:/admin/listTeams";
    }
}
