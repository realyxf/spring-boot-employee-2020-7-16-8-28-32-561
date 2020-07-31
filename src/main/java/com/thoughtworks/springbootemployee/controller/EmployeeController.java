package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Employee getEmployee(@PathVariable int employeeId) throws Exception {
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

    @PutMapping("/{employeeId}")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse addEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return employeeService.addEmployee(employeeRequest);
    }

}
