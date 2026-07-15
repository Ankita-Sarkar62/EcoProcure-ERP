package com.ecoprocure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ecoprocure.entity.Employee;
import com.ecoprocure.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController //http request
public class EmployeeController {
    @Autowired
    private EmployeeService es;

    @GetMapping("/employees")//handles GET request(fetchall employee)
    public List<Employee> getAllEmployees(){
        return es.getAllEmployees();
    }



    @PostMapping("/employees")//handles POST request(insert new employee)
    public Employee saveEmployee(@RequestBody Employee emp) {//@RequestBody: converts the incoming JSON into Employee obj
       
        return es.saveEmployee(emp);
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){//@PathVariable: http://localhost:8081/employees/2  ->  Integer id=2
        return es.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        es.deleteEmployee(id);
        return "Employee deleted Successfully";
    }



    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee emp){
        return es.updateEmployee(id, emp);
    }
    
}
