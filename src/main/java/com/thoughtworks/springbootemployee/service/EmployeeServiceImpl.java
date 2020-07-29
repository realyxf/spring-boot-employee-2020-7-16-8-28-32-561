package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
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

    public Employee getEmployee(int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }
}
