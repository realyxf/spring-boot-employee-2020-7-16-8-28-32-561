package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    public void deleteEmployee(int employeeId) {
        employeeList.removeIf(employee -> employee.getId() == employeeId);
    }

    public void updateEmployee(Employee employee) {
        employeeList.remove(employee.getId());
        employeeList.add(employee);
    }

    public void addEmployeeList(List<Employee> inputEmployeeList) {
        employeeList.addAll(inputEmployeeList);
    }

    public Employee getEmployee(int employeeId){
        return employeeList.get(employeeId);
    }
}
