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

    private int id;

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

}
