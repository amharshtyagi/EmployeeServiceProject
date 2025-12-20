package com.harshtyagi.Employee_Service.service;

import com.harshtyagi.Employee_Service.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    List<Employee> listOfEmployees = new ArrayList<>();
    public EmployeeService() {
        listOfEmployees.add(new Employee("Harsh",200,"harsh@comp.com","IT"));
        listOfEmployees.add(new Employee("Aditya",201,"Adi@comp.com","IT"));
        listOfEmployees.add(new Employee("Kshitiz",202,"KS@comp.com","IT"));
    }

    public List<Employee> getListOfEmployees(){
        return listOfEmployees;
    }
}
