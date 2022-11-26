package ru.zainetdinova.springbootcourse.service;

import ru.zainetdinova.springbootcourse.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles();
    public Role getRole(int id);
}
