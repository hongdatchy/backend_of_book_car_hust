package com.hongdatchy.bookcar.service_impl;

import com.hongdatchy.bookcar.entities.model.Driver;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.repo.DriverRepo;
import com.hongdatchy.bookcar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService_impl implements DriverService {

    @Autowired
    DriverRepo driverRepo;


    @Override
    public boolean login(LoginForm loginForm) {
        return driverRepo.login(loginForm);
    }


}
