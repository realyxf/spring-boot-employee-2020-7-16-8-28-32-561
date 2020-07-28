package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public List<Employee> getCurPageEmployees(@RequestParam(required = false) Integer page,
                                              @RequestParam(required = false) Integer pageSize,
                                              @RequestParam(required = false) String gender) {
        if (page == null && pageSize == null && gender == null) {
            return employeeService.getAllEmployee();
        }

        if(page == null && pageSize == null && gender != null){
            return employeeService.getEmployeeWithGender(gender);
        }
        return employeeService.getEmployeesOfCurPage(page, pageSize);
    }

    @PostMapping(path = "/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping(path = "/employees/{employeeId}")
    public void updateEmployee(@PathVariable int employeeId,@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping(path = "/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PostMapping(path = "/employeeslist")
    public void addEmployeeList(@RequestBody List<Employee> inputEmployeeList) {
        employeeService.addEmployeeList(inputEmployeeList);
    }

    @GetMapping(path = "/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

}
