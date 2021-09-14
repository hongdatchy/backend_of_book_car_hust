package com.hongdatchy.bookcar.controller;

import com.hongdatchy.bookcar.entities.json.MyResponse;
import com.hongdatchy.bookcar.entities.model.User;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.security.JWTService;
import com.hongdatchy.bookcar.service.DriverService;
import com.hongdatchy.bookcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    @Autowired
    JWTService jwtService;

//    @PostMapping("api/dv/driver/apply_contract")
//    public ResponseEntity<Object> driverLogin(@RequestBody String contractId, @RequestHeader String token) {
//        User user = driverService.findByUsername(jwtService.decode(token));
//        if(user != null){
//            return ResponseEntity.ok(MyResponse.success(userService.book(bookPayload, user)));
//        }
//        return ResponseEntity.ok(MyResponse.fail(false));
//    }



}
