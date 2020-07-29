package com.thoughtworks.springbootemployee.entity;

import com.thoughtworks.springbootemployee.service.CompanyService;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int id;

    private List<Employee> employeeList = new ArrayList<>();

    public Company(int id){
        this.id = id;
    }
    public Company(){}


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
