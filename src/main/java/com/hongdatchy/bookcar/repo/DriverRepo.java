package com.hongdatchy.bookcar.repo;

import com.hongdatchy.bookcar.entities.model.Driver;
import com.hongdatchy.bookcar.entities.payload.LoginForm;

public interface DriverRepo {
    boolean login(LoginForm loginForm);
    Driver findByUsername(String username);
}
