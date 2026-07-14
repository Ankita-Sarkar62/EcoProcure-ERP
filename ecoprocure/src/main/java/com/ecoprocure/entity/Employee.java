package com.ecoprocure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValues(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "department")
    private String department;
    @Column(name = "role")
    private String role;

     public Employee(){

    }//default constructor because it creates obj automatically when fetching data from the database

    public Employee(int employeeId, String employeeName,String email, String password,String phoneNumber, String department, String role){
        this. employeeId=employeeId;
        this.employeeName=employeeName;
        this.email=email;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.department=department;
        this.role=role;
    }



    //source Action -> generate getter and setter -> select all fields-> ok
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //source action-> generate tostring()
    //I overrode toString() so that whenever an Employee object is printed, it displays meaningful employee details instead of the default object reference.
    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
                + ", password=" + password + ", phoneNumber=" + phoneNumber + ", department=" + department + ", role="
                + role + ", getEmployeeId()=" + getEmployeeId() + ", getEmployeeName()=" + getEmployeeName()
                + ", getClass()=" + getClass() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
                + ", getPhoneNumber()=" + getPhoneNumber() + ", getDepartment()=" + getDepartment() + ", getRole()="
                + getRole() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

   
}
