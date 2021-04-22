package com.hongdatchy.bookcar.repo;

import com.hongdatchy.bookcar.entities.model.User;
import com.hongdatchy.bookcar.entities.payload.LoginForm;

public interface UserRepo {

    boolean login(LoginForm loginForm);

    User findByUsername(String username);
}
