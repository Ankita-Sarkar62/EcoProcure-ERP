package com.ecoprocure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecoprocure.entity.Employee;
import com.ecoprocure.service.EmployeeService;

@RestController //http request
public class EmployeeController {
    @Autowired
    private EmployeeService es;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return es.getAllEmployees();
    }
}
