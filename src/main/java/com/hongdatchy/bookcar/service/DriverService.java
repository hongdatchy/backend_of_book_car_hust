package com.hongdatchy.bookcar.service;

import com.hongdatchy.bookcar.entities.model.Driver;
import com.hongdatchy.bookcar.entities.payload.LoginForm;

public interface DriverService {
    boolean login(LoginForm loginForm);
//    boolean agreeToDrive()
}
