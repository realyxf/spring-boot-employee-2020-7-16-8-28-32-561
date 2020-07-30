package com.thoughtworks.springbootemployee.dto;

import javax.validation.constraints.NotBlank;

public class EmployeeRequest {

    @NotBlank
    private String name;

    private int age;
    private String gender;
    private int company_id;

    public EmployeeRequest(String name, int age, String gender, int company_id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.company_id = company_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
