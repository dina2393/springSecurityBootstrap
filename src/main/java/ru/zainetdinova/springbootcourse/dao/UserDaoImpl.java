package ru.zainetdinova.springbootcourse.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.zainetdinova.springbootcourse.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Query<User> query = (Query<User>) entityManager.createQuery("delete from User u where id =:userId");
        query.setParameter("userId",id);
        query.executeUpdate();

    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    @Override
    public User getUserByName(String userName) {
            User user = entityManager.createQuery("select u from User u where u.userName = :name", User.class)
                    .setParameter("name", userName)
                    .getSingleResult();
            return user;
    }

}
