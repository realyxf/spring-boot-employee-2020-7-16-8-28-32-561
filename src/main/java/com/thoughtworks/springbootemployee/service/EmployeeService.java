package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

    //List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public List<Employee> getEmployeesOfCurPage(int page, int pageSize);

    public List<Employee> getEmployeeWithGender(String gender);

    public void deleteEmployee(int employeeId);

    public void updateEmployee(Employee employee);

    public void addEmployeeList(List<Employee> inputEmployeeList);

    public Employee getEmployee(int employeeId);

}
