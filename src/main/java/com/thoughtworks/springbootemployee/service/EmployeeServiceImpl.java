package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.ExceptionHandler.EmployeeNotFoundException;
import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.dto.EmployeeResponse;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesOfCurPage(int page, int pageSize) {
        int length = employeeRepository.findAll().size();

        if ((page - 1) * pageSize > length - 1){
            return new ArrayList<>();
        }

        return employeeRepository.findAll()
                .subList(Math.min((page - 1) * pageSize,length-1),Math.min(length, page * pageSize));
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        Optional<Company> company = companyRepository.findById(employeeRequest.getCompany_id());
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequest, employee);
        employee.setCompany(company.get());

        Employee employeeReturn = employeeRepository.save(employee);
        EmployeeResponse employeeResponse = new EmployeeResponse();
        BeanUtils.copyProperties(employeeReturn, employeeResponse);
        employeeResponse.setCompanyName(company.get().getCompanyName());
        return employeeResponse;
    }


    @Override
    public List<Employee> getEmployeeWithGender(String gender) {
        return employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void addEmployeeList(List<Employee> inputEmployeeList) {
        employeeRepository.saveAll(inputEmployeeList);
    }

    public Employee getEmployee(int employeeId) throws Exception {
        return employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee getEmployee1(EmployeeRequest employeeRequest) {
        Optional<Company> company = companyRepository.findById(employeeRequest.getCompany_id());
        Employee employee = new Employee();

        employee.setAge(employeeRequest.getAge());
        employee.setGender(employeeRequest.getGender());
        employee.setName(employeeRequest.getName());
        employee.setCompany(company.get());

        employeeRepository.save(employee);

        return employee;
    }
}
