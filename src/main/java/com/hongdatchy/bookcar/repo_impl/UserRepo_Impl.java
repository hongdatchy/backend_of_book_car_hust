package com.hongdatchy.bookcar.repo_impl;

import com.hongdatchy.bookcar.entities.model.User;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.repo.UserRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserRepo_Impl implements UserRepo {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public boolean login(LoginForm loginForm) {
        User user = findByUsername(loginForm.getUsername());
        return user!= null && user.getPass().equals(loginForm.getPass());
    }

    @Override
    public User findByUsername(String username) {
        List<User> users = entityManager.createQuery("select x from User x where x.userName = :username")
                .setParameter("username", username)
                .getResultList();
        return users.size() == 0 ? null : users.get(0);
    }
}
