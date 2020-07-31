package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public List<Employee> getEmployeesOfCurPage(int page, int pageSize);

    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    public List<Employee> getEmployeeWithGender(String gender);

    public void deleteEmployee(int employeeId);

    public void updateEmployee(Employee employee);

    public void addEmployeeList(List<Employee> inputEmployeeList);

    public Employee getEmployee(int employeeId) throws Exception;


}
