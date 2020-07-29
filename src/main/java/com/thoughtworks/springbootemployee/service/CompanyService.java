package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface CompanyService {

    List<Company> companyList = new ArrayList<>();

    public List<Company> getAllCompany();

    public Company getCompany(int companyId);

    public List<Employee> getEmployeesOfCompany(int companyId);

    public List<Company> getCompanyOfCurPage(int page, int pageSize);

    public void addCompany(Company company);

    public void updateCompany(Company newCompany);

    public void deleteCompany(int companyId);


}
