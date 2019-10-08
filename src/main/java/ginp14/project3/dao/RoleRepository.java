package ginp14.project3.dao;

import ginp14.project3.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
    Role findById(int id);
}
