package com.hongdatchy.bookcar.service_impl;

import com.hongdatchy.bookcar.entities.model.Contract;
import com.hongdatchy.bookcar.entities.model.User;
import com.hongdatchy.bookcar.entities.payload.BookPayload;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.repo.ContractRepo;
import com.hongdatchy.bookcar.repo.UserRepo;
import com.hongdatchy.bookcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserService_Impl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ContractRepo contractRepo;

    @Override
    public boolean login(LoginForm loginForm) {
        return userRepo.login(loginForm);
    }

    @Override
    public Contract book(BookPayload bookPayload, User user) {
        return contractRepo.createAndUpdate(Contract.builder()
                .userId(user.getId())
                .time(new Timestamp(new Date().getTime()))
                .distance(bookPayload.getDistance())
                .cost(bookPayload.getCost())
                .build());
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
