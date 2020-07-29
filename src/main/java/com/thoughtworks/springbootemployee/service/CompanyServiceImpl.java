package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl {
    private List<Company> companyList = new ArrayList<>();

    public List<Company> getAllCompany() {
        return companyList;
    }

    public Company getCompany(int companyId) {
        return companyList.get(companyId);
    }

    public List<Employee> getEmployeesOfCompany(int companyId) {
        return companyList.get(companyId).getEmployeeList();
    }

    public List<Company> getCompanyOfCurPage(int page, int pageSize) { //TODO fixbug
        List<Company> curPageCompany = new ArrayList<>();
        if (page == 1) {
            for (int companyItem = 0; companyItem < pageSize; companyItem++) {
                curPageCompany.add(companyList.get(companyItem));
            }
        }
        else {
            for (int companyItem = (pageSize * (page - 1)); companyItem < page * pageSize; companyItem++) {
                curPageCompany.add(companyList.get(companyItem));
            }
        }
        return curPageCompany;
    }

    public void addCompany(Company company) {
        companyList.add(company);
    }

    public void updateCompany(Company newCompany) {
        companyList.removeIf(company -> company.getId() == newCompany.getId());
        companyList.add(newCompany);
    }

    public void deleteCompany(int companyId){
        companyList.removeIf(company -> company.getId() == companyId);
    }

}
