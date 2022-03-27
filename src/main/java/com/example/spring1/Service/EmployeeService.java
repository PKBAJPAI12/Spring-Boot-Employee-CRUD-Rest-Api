package com.example.spring1.Service;


import com.example.spring1.Model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
}
