package com.thoughtworks.springbootemployee.entity;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int id;
    private List<Employee> employeeList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
