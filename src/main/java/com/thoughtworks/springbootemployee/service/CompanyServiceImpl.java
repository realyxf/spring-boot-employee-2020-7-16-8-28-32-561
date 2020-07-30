package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.ExceptionHandler.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(int companyId) throws Exception{
        return companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);
    }

    @Override
    public List<Employee> getEmployeesOfCompany(int companyId) {
        Company company = companyRepository.findById(companyId).orElse(null);
        return company != null ? company.getEmployeesList() : null;
    }

    @Override
    public List<Company> getCompanyOfCurPage(int page, int pageSize) {
        int length = companyRepository.findAll().size();

        if ((page - 1) * pageSize > length - 1) {
            return new ArrayList<>();
        }
        return companyRepository.findAll()
                .subList(Math.min((page - 1) * pageSize, length - 1), Math.min(length, page * pageSize));
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Company newCompany) {
        companyRepository.save(newCompany);
    }

    @Override
    public void deleteCompany(int companyId) {
        companyRepository.deleteById(companyId);
    }
}
