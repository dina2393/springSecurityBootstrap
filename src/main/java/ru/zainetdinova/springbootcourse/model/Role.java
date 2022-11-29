package ru.zainetdinova.springbootcourse.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role"
            ,joinColumns = @JoinColumn(name = "role_id")
            ,inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    public Role(){}

    public Role(String role) {
        this.role =role;
    }
//    public void addUserToRole(User user) {
//        if (users == null){
//            users = new ArrayList<>();
//        } else{
//            users.add(user);
//        }
//    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getRole() {return role;}
    public void setRole(String role) {this.role = role;}

    public Set<User> getUsers() {return users;}
    public void setUsers(Set<User> users) {this.users = users;}

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
