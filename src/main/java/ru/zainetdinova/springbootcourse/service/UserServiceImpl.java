package ru.zainetdinova.springbootcourse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zainetdinova.springbootcourse.dao.UserDao;
import ru.zainetdinova.springbootcourse.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public List<User> getAllUsers() {
       return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }
    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }
    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }


}
