package com.example.spring1.ServiceImpl;

import com.example.spring1.Model.Employee;
import com.example.spring1.Repository.EmployeeRepository;
import com.example.spring1.Service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee){

        return  employeeRepository.save(employee);
    }
}
