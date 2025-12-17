package com.harshtyagi.Employee_Service.model;


public class Employee {
    private String EmployeeName;

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeName='" + EmployeeName + '\'' +
                '}';
    }

    public Employee(String employeeName) {
        EmployeeName = employeeName;
    }
}
