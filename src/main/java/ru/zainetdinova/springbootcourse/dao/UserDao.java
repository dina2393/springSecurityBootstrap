package ru.zainetdinova.springbootcourse.dao;


import ru.zainetdinova.springbootcourse.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void saveUser(User user);
    public User getUser(long id);
    public void deleteUser(long id);
    public void updateUser(User user);
}
