package ginp14.project3.service;

import ginp14.project3.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    public User findByUsername(String username);
    public void saveUser(User user);
    public List<User> findAll();
    public boolean isUserExisted(String username);
    public boolean isEmailExisted(String email);
}
