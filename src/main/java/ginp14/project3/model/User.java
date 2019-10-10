package ginp14.project3.model;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username", unique = true)
    @Size(min = 5, max = 20, message = "Username must be between 8 and 20 characters")
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @Column(name = "password", columnDefinition = "varchar(255)")
    @NotBlank(message = "Password cannot be empty")
    private String password;

    @Column(name = "full_name")
    @NotBlank(message = "Full name cannot be empty")
    private String fullName;

    @Column(name = "DOB")
    @NotBlank(message = "Please select date of birth")
    private String dob;

    @Column(name = "gender")
    private int gender; // 1 - Male // 2 - Female // 3 - Not prefer to say

    @Column(name = "email")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Column(name = "address")
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @Column(name = "phone")
    @NotBlank(message = "Phone cannot be empty")
    private String phone;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "status", columnDefinition = "tinyint(1)")
    private boolean status;

    @Column(name = "created_at")
    @UpdateTimestamp
    private Timestamp created_at;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updated_at;

    public User() {
    }

    public User(@Size(min = 5, max = 20, message = "Username must be between 8 and 20 characters") @NotBlank(message = "Username cannot be empty") String username, @NotBlank(message = "Password cannot be empty") String password, @NotBlank(message = "Full name cannot be empty") String fullName, @NotBlank(message = "Please select date of birth") String dob, int gender, @NotBlank(message = "Email cannot be empty") String email, @NotBlank(message = "Address cannot be empty") String address, @NotBlank(message = "Phone cannot be empty") String phone, Role role, boolean status, Timestamp created_at, Timestamp updated_at) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.role = role;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }
}
