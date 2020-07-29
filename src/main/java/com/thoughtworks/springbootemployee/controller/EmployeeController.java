package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping(params = {"page","pageSize"})
    public List<Employee> getEmployeesOfCurPage(@RequestParam int page,@RequestParam int pageSize){
        return employeeService.getEmployeesOfCurPage(page,pageSize);
    }

    @GetMapping(params = "gender")
    public List<Employee> getEmployeeWithGender(@RequestParam String gender){
        return employeeService.getEmployeeWithGender(gender);
    }

}
