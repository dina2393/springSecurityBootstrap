package ru.zainetdinova.springbootcourse.dao;

import ru.zainetdinova.springbootcourse.model.Role;
import ru.zainetdinova.springbootcourse.model.User;

import java.util.List;

public interface RoleDao {
    public List<Role> getAllRoles();
    public Role getRole(int id);
    public Role getRoleByName(String roleName);

}
