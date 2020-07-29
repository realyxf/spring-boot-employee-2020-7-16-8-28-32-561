package com.thoughtworks.springbootemployee.entity;

import com.thoughtworks.springbootemployee.service.CompanyService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column( name = "company_id")
    private int id;

    @Column( name = "name")
    private String companyName;

    @OneToMany(mappedBy="company")
    private List<Employee> employeesList;

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

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public String getCompanyName() {
        return companyName;
    }
}
