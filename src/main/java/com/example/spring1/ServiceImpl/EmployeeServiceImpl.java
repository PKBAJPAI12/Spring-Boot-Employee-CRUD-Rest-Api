package com.example.spring1.ServiceImpl;

import com.example.spring1.Exception.ResourceNotFound;
import com.example.spring1.Model.Employee;
import com.example.spring1.Repository.EmployeeRepository;
import com.example.spring1.Service.EmployeeService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
       /* Optional<Employee> employee=employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new ResourceNotFound("Employee","Id",id);
        }*/
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee","Id",id));
    }
}
