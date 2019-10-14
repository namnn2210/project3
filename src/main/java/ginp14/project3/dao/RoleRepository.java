package ginp14.project3.dao;

import ginp14.project3.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findById(int id);
}
