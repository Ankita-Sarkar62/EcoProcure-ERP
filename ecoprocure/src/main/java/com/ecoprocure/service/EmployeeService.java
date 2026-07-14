package com.ecoprocure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecoprocure.entity.Employee;
import com.ecoprocure.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired   //Dependency injection: we can use the EmployeeRepository interface  
    private EmployeeRepository er;

    public List<Employee> getAllEmployees(){
        return er.findAll();
    }
}
