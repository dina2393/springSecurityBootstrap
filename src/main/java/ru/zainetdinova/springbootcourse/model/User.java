package ru.zainetdinova.springbootcourse.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password_name")
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role"
            ,joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles =  new HashSet<>();

    public User(){
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Set<Role> getRoles() {return roles;}
    public void setRoles(Set<Role> roles) {this.roles = roles;}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }
    @Override
    public String getUsername() {
        return getUserName();
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
        return true;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
        public void addRoleToUser(Role role) {
            this.roles.add(role);

    }
}
