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

    public List<Employee> getEmployeesOfCurPage(int page, int pageSize) {
        List<Employee> curPageEmployees = new ArrayList<>();
        if (page == 1) {
            for (int employeeItem = 0; employeeItem < pageSize; employeeItem++) {
                curPageEmployees.add(employeeList.get(employeeItem));
            }
        } else {
            for (int employeeItem = (pageSize * (page - 1)); employeeItem < page * pageSize; employeeItem++) {
                curPageEmployees.add(employeeList.get(employeeItem));
            }
        }
        return curPageEmployees;
    }

    public List<Employee> getEmployeeWithGender(String gender){
        List<Employee> curEmployee = new ArrayList<>();
        for(int employeeItem = 0; employeeItem < employeeList.size(); employeeItem++){
            if(employeeList.get(employeeItem).getGender().equals(gender)){
                curEmployee.add(employeeList.get(employeeItem));
            }
        }
        return curEmployee;
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

    public Employee getEmployee(int employeeId) {
        return employeeList.get(employeeId);
    }
}
