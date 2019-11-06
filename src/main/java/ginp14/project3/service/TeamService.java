package ginp14.project3.service;

import ginp14.project3.model.Team;

import java.util.List;

public interface TeamService {
    List<Team>findAll();
    Team findById(int id);
    void save(Team team);
}
