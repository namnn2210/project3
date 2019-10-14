package ginp14.project3.dao;

import ginp14.project3.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
