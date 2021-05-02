package com.hongdatchy.bookcar.service;

import com.hongdatchy.bookcar.entities.model.User;
import com.hongdatchy.bookcar.entities.payload.BookPayload;
import com.hongdatchy.bookcar.entities.payload.LoginForm;

public interface UserService {

    boolean login(LoginForm loginForm);
    boolean book(BookPayload bookPayload, User user);
    User findByUsername(String username);
}
