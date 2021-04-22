package com.hongdatchy.bookcar.controller;

import com.hongdatchy.bookcar.entities.json.MyResponse;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.security.JWTService;
import com.hongdatchy.bookcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("api/us/user/login")
    public ResponseEntity<Object> userLogin(@RequestBody LoginForm loginForm) throws Exception {
        JWTService jwtService = new JWTService();
        if(userService.login(loginForm)){
            String token = jwtService.getToken(loginForm.getUsername());
            return ResponseEntity.ok(MyResponse.loginSuccess("user",token));
        }
        return ResponseEntity.ok(MyResponse.fail("invalidate username or password"));
    }

}
