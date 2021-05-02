package com.hongdatchy.bookcar.repo_impl;

import com.hongdatchy.bookcar.entities.model.Driver;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.repo.DriverRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class DriverRepo_Impl implements DriverRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean login(LoginForm loginForm) {
        Driver driver = findByUsername(loginForm.getUsername());
        return driver != null && driver.getPass().equals(loginForm.getPass());
    }

    @Override
    public Driver findByUsername(String username) {
        List<Driver> drivers = entityManager.createQuery("select x from Driver x where x.userName =: username")
                .setParameter("username", username)
                .getResultList();
        return drivers.size() == 0 ? null : drivers.get(0);
    }
}
