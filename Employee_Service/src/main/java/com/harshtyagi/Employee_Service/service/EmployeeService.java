package com.harshtyagi.Employee_Service.service;

import com.harshtyagi.Employee_Service.exception.EmployeeNotFoundException;
import com.harshtyagi.Employee_Service.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    List<Employee> listOfEmployees = new ArrayList<>();
    public EmployeeService() {
        listOfEmployees.add(new Employee("Harsh",200,"harsh@comp.com","IT"));
        listOfEmployees.add(new Employee("Aditya",201,"Adi@comp.com","IT"));
        listOfEmployees.add(new Employee("Kshitiz",202,"KS@comp.com","IT"));
    }

    public List<Employee> getAllEmployees(){
        return listOfEmployees;
    }

    public Employee addEmployeeData(Employee employee1){
        boolean b = listOfEmployees.add(employee1);
        if(b == true) System.out.println("New employee added");
        else System.out.println("Failed to add new employee");
        return employee1;
    }

    public Employee getEmployeeById(long id) {
        for(Employee employee: listOfEmployees){
            if(employee.getEmployeeId()==id)
                return employee;
        }
        throw new EmployeeNotFoundException("Employee with given Id not found");
    }
}
