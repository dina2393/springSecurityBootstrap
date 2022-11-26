package ru.zainetdinova.springbootcourse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zainetdinova.springbootcourse.configs.PasswordEncoderService;
import ru.zainetdinova.springbootcourse.dao.RoleDao;
import ru.zainetdinova.springbootcourse.dao.UserDao;
import ru.zainetdinova.springbootcourse.model.Role;
import ru.zainetdinova.springbootcourse.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    UserDao userDao;
    PasswordEncoder passwordEncoder;
    RoleDao roleDao;

    @Autowired
    public UserServiceImpl(UserDao userDao,PasswordEncoder passwordEncoder,RoleDao roleDao) {

        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.roleDao = roleDao;
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
       return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void saveUser(User user) {

        Role roleUser = roleDao.getRoleByName("ROLE_USER");
        user.addRoleToUser(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));


        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

}
