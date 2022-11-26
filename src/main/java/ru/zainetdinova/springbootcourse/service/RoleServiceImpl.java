package ru.zainetdinova.springbootcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zainetdinova.springbootcourse.dao.RoleDao;
import ru.zainetdinova.springbootcourse.model.Role;

import java.util.List;
@Service

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;
    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    @Transactional
    public Role getRole(int id) {
        return roleDao.getRole(id);
    }
}
