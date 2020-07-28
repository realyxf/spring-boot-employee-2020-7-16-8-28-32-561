package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping(path = "/companies")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @GetMapping(path = "/companies")
    public List<Company> getCompanyOfCurPage(@RequestParam(required = false) Integer page,
                                             @RequestParam(required = false) Integer pageSize) {
        if (page == null || pageSize == null) {
            return companyService.getAllCompany();
        }
        return companyService.getCompanyOfCurPage(page, pageSize);
    }

    @GetMapping(path = "/companies/{companyId}")
    public Company getCompany(@PathVariable int companyId) {
        return companyService.getCompany(companyId);
    }

    @GetMapping(path = "/companies/{companyId}/employees")
    public List<Employee> getEmployeesOfCompany(@PathVariable int companyId) {
        return companyService.getCompany(companyId).getEmployeeList();
    }

    @PutMapping(path = "/companies/{companyId}")
    public void updateCompany(@PathVariable int companyId, @RequestBody Company newCompany) {
        companyService.updateCompany(newCompany);
    }

    @DeleteMapping(path = "/companies/{companyId}")
    public void deleteCompany(@PathVariable int companyId) {
        companyService.deleteCompany(companyId);
    }
}
