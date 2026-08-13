package com.ecoprocure.service;


import java.util.List;

import com.ecoprocure.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecoprocure.dto.LoginResponse;
import com.ecoprocure.dto.LoginRequest;
import com.ecoprocure.dto.LoginResponse;
import com.ecoprocure.entity.Employee;
import com.ecoprocure.exception.ResourceNotFoundException;
import com.ecoprocure.repository.EmployeeRepository;

@Service
public class EmployeeService {
    


    @Autowired   //Dependency injection: we can use the EmployeeRepository interface without manual obj creation  
    private EmployeeRepository er;

 
    //get all employee
    public List<Employee> getAllEmployees(){
        return er.findAll();
    }

    //insert employee
    public Employee saveEmployee(Employee emp){//if emp is new: INSERT or if already exists: UPDATE
        return er.save(emp);
    }

    //get employee by id or nothing
    public Employee getEmployeeById(Integer id){
        return er.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not found with ID: " + id));
    }

    //delete emp with the id no=
    public void deleteEmployee(Integer id){
        Employee emp= er.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not found with ID: " + id));
        er.delete(emp);
    }

    public Employee updateEmployee(Integer id, Employee emp){
        er.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not found with ID: " + id));
        emp.setEmployeeId(id);//if we dont write setEmployeeId(id)..the Hibernate thinks employeeId=null and instead of updating, it inserts value
        return er.save(emp);
    }

public LoginResponse login(LoginRequest LR) {

    Employee emp = er.findByEmail(LR.getEmail()).orElseThrow(() -> new BadRequestException("Invalid Email or password"));

    if (!emp.getPassword().equals(LR.getPassword())) {
        throw new BadRequestException("Invalid Email or password");
    }

    return new LoginResponse(emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmail(),emp.getDepartment(),emp.getRole());
}
}
