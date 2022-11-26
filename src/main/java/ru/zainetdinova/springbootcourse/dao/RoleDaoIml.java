package ru.zainetdinova.springbootcourse.dao;

import org.springframework.stereotype.Repository;
import ru.zainetdinova.springbootcourse.model.Role;
import ru.zainetdinova.springbootcourse.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository

public class RoleDaoIml implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Role> getAllRoles() {
        List<Role> allRoles = entityManager.createQuery("from Role", Role.class).getResultList();
        return allRoles;
    }

    @Override
    public Role getRole(int id) {
        Role role = entityManager.find(Role.class, id);
        return role;
    }
    @Override
    public Role getRoleByName(String roleName) {
        Role role = entityManager.createQuery("select r from Role r where r.role = :name", Role.class)
                .setParameter("name", roleName)
                .getSingleResult();
        return role;
    }
}
