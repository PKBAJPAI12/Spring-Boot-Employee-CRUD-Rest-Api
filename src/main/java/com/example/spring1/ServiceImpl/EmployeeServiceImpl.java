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

    @Override
    public Employee updateEmployee(Employee employee, long id) {
//We need to Check whether given Employee id Exist in DB or not
        Employee existingEmployee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee","Id",id));
    existingEmployee.setFirstName(employee.getFirstName());
    existingEmployee.setLastName(employee.getLastName());
    existingEmployee.setEmailId(employee.getEmailId());
    //save Exisiting Employee to DB
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //Check Employee Id exist in DB or not
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
