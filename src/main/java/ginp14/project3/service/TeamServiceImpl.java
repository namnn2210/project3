package ginp14.project3.service;

import ginp14.project3.dao.TeamRepository;
import ginp14.project3.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(int id) {
        return teamRepository.findById(id);
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }
}
