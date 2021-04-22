package com.hongdatchy.bookcar.service;

import com.hongdatchy.bookcar.entities.payload.LoginForm;

public interface UserService {
    boolean login(LoginForm loginForm);
}
