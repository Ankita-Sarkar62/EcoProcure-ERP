package com.ecoprocure.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecoprocure.entity.Employee;
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
        return er.findById(id).orElse(null);
    }

    //delete emp with the id no=
    public void deleteEmployee(Integer id){
        er.deleteById(id);
    }

    public Employee updateEmployee(Integer id, Employee emp){
        emp.setEmployeeId(id);//if we dont write setEmployeeId(id)..the Hibernate thinks employeeId=null and instead of updating, it inserts value
        return er.save(emp);
    }
}
