package com.harshtyagi.Employee_Service.service;

import com.harshtyagi.Employee_Service.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    List<Employee> listOfEmployees = new ArrayList<>();
    public EmployeeService() {
        listOfEmployees.add(new Employee("Harsh"));
        listOfEmployees.add(new Employee("Aditya"));
        listOfEmployees.add(new Employee("Kshitiz"));
    }

    public List<Employee> getListOfEmployees(){
        return listOfEmployees;
    }
}
