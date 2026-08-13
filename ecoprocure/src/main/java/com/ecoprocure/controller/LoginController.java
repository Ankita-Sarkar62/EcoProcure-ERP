package com.ecoprocure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecoprocure.dto.LoginRequest;
import com.ecoprocure.dto.LoginResponse;
import com.ecoprocure.entity.Employee;
import com.ecoprocure.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private EmployeeService es;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest LR){
        return es.login(LR);
    }
    
}
