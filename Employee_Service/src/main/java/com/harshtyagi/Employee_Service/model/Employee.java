package com.harshtyagi.Employee_Service.model;


import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

public class Employee {
    @NotBlank(message="EmployeeName must not be empty.")
    private String EmployeeName;
    private int EmployeeId;
    private String email;
    private String department;

    public Employee(String employeeName, int employeeId, String email, String department) {
        EmployeeName = employeeName;
        EmployeeId = employeeId;
        this.email = email;
        this.department = department;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeName='" + EmployeeName + '\'' +
                ", EmployeeId=" + EmployeeId + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
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
}
