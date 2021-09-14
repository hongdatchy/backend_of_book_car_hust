package com.hongdatchy.bookcar.controller;

import com.hongdatchy.bookcar.entities.json.MyResponse;
import com.hongdatchy.bookcar.entities.model.User;
import com.hongdatchy.bookcar.entities.payload.BookPayload;
import com.hongdatchy.bookcar.entities.payload.LoginForm;
import com.hongdatchy.bookcar.security.JWTService;
import com.hongdatchy.bookcar.service.ContractService;
import com.hongdatchy.bookcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JWTService jwtService;

    @Autowired
    ContractService contractService;

    @PostMapping("api/us/user/book")
    public ResponseEntity<Object> book(@RequestBody BookPayload bookPayload, @RequestHeader String token) {
        User user = userService.findByUsername(jwtService.decode(token));
        if(user != null){
            return ResponseEntity.ok(MyResponse.success(userService.book(bookPayload, user)));
        }
        return ResponseEntity.ok(MyResponse.fail(false));
    }

    @GetMapping("api/us/user/find_contract_by_userId")
    public ResponseEntity<Object> findContractById(@RequestHeader String token) {
        User user = userService.findByUsername(jwtService.decode(token));
        if(user != null){
            return ResponseEntity.ok(MyResponse.success(contractService.findByUserId(user.getId())));
        }
        return ResponseEntity.ok(MyResponse.fail(false));
    }

}
