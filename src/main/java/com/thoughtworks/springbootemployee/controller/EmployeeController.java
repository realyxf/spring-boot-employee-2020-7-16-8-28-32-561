package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @GetMapping(path = "/employees")
    public List<Employee> getCurPageEmployees(@RequestParam(required = false) Integer page,
                                              @RequestParam(required = false) Integer pageSize,
                                              @RequestParam(required = false) String gender) {
        if (page == null && pageSize == null && gender == null) {//TODO
            return employeeServiceImpl.getAllEmployee();
        }

        if(page == null && pageSize == null && gender != null){
            return employeeServiceImpl.getEmployeeWithGender(gender);
        }
        return employeeServiceImpl.getEmployeesOfCurPage(page, pageSize);
    }

    @PostMapping(path = "/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeServiceImpl.addEmployee(employee);
    }

    @PutMapping(path = "/employees/{employeeId}")
    public void updateEmployee(@PathVariable int employeeId,@RequestBody Employee employee) {
        employeeServiceImpl.updateEmployee(employee);
    }

    @DeleteMapping(path = "/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeServiceImpl.deleteEmployee(employeeId);
    }

    @PostMapping(path = "/employeeslist")
    public void addEmployeeList(@RequestBody List<Employee> inputEmployeeList) { //TODO dont push
        employeeServiceImpl.addEmployeeList(inputEmployeeList);
    }

    @GetMapping(path = "/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeServiceImpl.getEmployee(employeeId);
    }

}
