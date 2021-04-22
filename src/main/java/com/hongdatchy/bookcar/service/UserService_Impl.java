package com.hongdatchy.bookcar.service;

import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService_Impl implements  UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public boolean login(LoginForm loginForm) {
        return userRepo.login(loginForm);
    }
}
