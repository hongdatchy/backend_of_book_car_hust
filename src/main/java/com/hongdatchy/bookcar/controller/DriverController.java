//package com.hongdatchy.bookcar.controller;
//
//import com.hongdatchy.bookcar.entities.json.MyResponse;
//import com.hongdatchy.bookcar.entities.payload.LoginForm;
//import com.hongdatchy.bookcar.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class DriverController {
//
//    @Autowired
//    UserService userService;
//
//    @PostMapping("api/dv/driver/login")
//    public ResponseEntity<Object> userLogin(@RequestBody LoginForm loginForm) {
//        if(userService.login(loginForm)){
//            return ResponseEntity.ok(MyResponse.success("driver"));
//        }
//        return ResponseEntity.ok(MyResponse.fail("invalidate username or password"));
//    }
//
//}
