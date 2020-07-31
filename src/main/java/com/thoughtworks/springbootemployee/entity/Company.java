package com.thoughtworks.springbootemployee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Employee> employeesList;

    public Company(String companyName){
        this.companyName = companyName;
    }

    public Company(int id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

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
