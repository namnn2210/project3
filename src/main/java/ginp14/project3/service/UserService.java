package ginp14.project3.service;

import ginp14.project3.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    void saveUser(User user);
    List<User> findAll();
    boolean isUserExisted(String username);
    boolean isEmailExisted(String email);
    User findById(int id);
    void addUser(User user);
}
