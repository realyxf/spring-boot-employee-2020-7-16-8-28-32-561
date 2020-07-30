package com.thoughtworks.springbootemployee;

import com.thoughtworks.springbootemployee.dto.EmployeeRequest;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    CompanyRepository companyRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void should_return_1_employees_when_getallemployees_given_1_employees() {

        // given
        int commpanId = 1;
        Company company = new Company(commpanId);
        Employee  employee = new Employee(1,"AAA",11,"male",company);
        EmployeeRequest employeeRequest = new EmployeeRequest("AAA",11,"male",commpanId);
        Mockito.when(companyRepository.findById(any())).thenReturn(java.util.Optional.of(company));

        // when
        Employee employeesQueried = employeeService.getEmployee1(employeeRequest);

        // then
        assertEquals(employee.getName(),employeesQueried.getName());
    }
}
