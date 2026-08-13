package com.ecoprocure.dto;

public class LoginResponse {
    private Integer employeeId;
    private String employeeName;
    private String email;
    private String department;
    private String role;

    public LoginResponse(){

    }

    public LoginResponse(Integer employeeId, String employeeName, String email, String department, String role){
        this.employeeId=employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.department = department;
        this.role = role;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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
}
