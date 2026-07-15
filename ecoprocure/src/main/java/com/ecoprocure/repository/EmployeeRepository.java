package com.ecoprocure.repository;
import org.springframework.data.jpa.repository.JpaRepository;//JpaRepository includes : save(), findAll(), findById(), delete(), deleteById(), count(), existsById()
import org.springframework.stereotype.Repository;
import com.ecoprocure.entity.Employee;

@Repository //tells the springboot that this class is responsible for database operation


//JpaRepository<Employee, Integer>: tells that which table we should work with -> Employee..........Integer: datatype of the primary key
//we don't need to write sql manually
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
}
