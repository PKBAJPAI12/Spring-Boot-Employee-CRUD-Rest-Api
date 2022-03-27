package com.example.spring1.Controller;


import com.example.spring1.Model.Employee;
import com.example.spring1.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    //Build Create Employee Rest API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //Build GET ALL Employee Rest API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    //Get Employee Details By Id Rest API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return  new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);

    }
    //Update Employee Rest Api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
    }

    //Build Delete Employee Rest API
@DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee Deleted Successfully",HttpStatus.OK );
    }
}
