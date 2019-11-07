package ginp14.project3.service;

import ginp14.project3.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(int id);
}
