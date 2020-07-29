package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/companies")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompany();
    }

    @PostMapping
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @GetMapping(params = {"page", "pageSize"})
    public List<Company> getCompanyOfCurPage(@RequestParam Integer page,
                                             @RequestParam Integer pageSize) {
        return companyService.getCompanyOfCurPage(page, pageSize);
    }

    @GetMapping(path = "/{companyId}")
    public Company getCompany(@PathVariable int companyId) {
        return companyService.getCompany(companyId);
    }


    @GetMapping(path = "/{companyId}/employees")
    public List<Employee> getEmployeesOfCompany(@PathVariable int companyId) {
        return companyService.getEmployeesOfCompany(companyId);
    }


    @PutMapping(path = "/{companyId}")
    public void updateCompany(@PathVariable int companyId, @RequestBody Company newCompany) {
        companyService.updateCompany(newCompany);
    }

    @DeleteMapping(path = "/{companyId}")
    public void deleteCompany(@PathVariable int companyId) {
        companyService.deleteCompany(companyId);
    }
}
