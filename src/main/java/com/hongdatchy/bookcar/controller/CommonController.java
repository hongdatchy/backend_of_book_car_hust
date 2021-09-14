package com.hongdatchy.bookcar.controller;

import com.hongdatchy.bookcar.entities.json.DataLogin;
import com.hongdatchy.bookcar.entities.json.MyResponse;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.security.JWTService;
import com.hongdatchy.bookcar.service.DriverService;
import com.hongdatchy.bookcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @Autowired
    UserService userService;

    @Autowired
    DriverService driverService;

    @Autowired
    JWTService jwtService;

    @PostMapping("api/public/common/login")
    public ResponseEntity<Object> userLogin(@RequestBody LoginForm loginForm) {
        System.out.println(loginForm);
        if(userService.login(loginForm)){
            String phone = userService.findByUsername(loginForm.getUsername()).getPhone();
            return ResponseEntity.ok(MyResponse
                    .loginSuccess("user", new DataLogin(phone,jwtService.getToken(loginForm.getUsername()))));
        }else if(driverService.login(loginForm)){
            return ResponseEntity.ok(MyResponse
                    .loginSuccess("driver", jwtService.getToken(loginForm.getUsername())));
        }
        return ResponseEntity.ok(MyResponse.fail("invalidate username or password"));
    }
    

}
