package com.thoughtworks.springbootemployee.integrationtest;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }

    @Test
    void should_return_ok_when_find_employee() throws Exception {
        mockMvc.perform(get("/employees")).andExpect(status().isOk());
    }

    @Test
    void should_return_2_employees_when_find_all_employees_given_2_employees() throws Exception {
        Employee employee1 = new Employee("a");
        Employee employee2 = new Employee("b");
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].name").value("a"))
                .andExpect(jsonPath("[1].name").value("b"));
    }

    @Test
    void should_return_1_employee_when_add_1_employee_given_1_employee() throws Exception {
        String companyJson = "{\n" +
                "    \"companyName\": \"OOCL\"\n" +
                "}";
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(companyJson));

        String employeeJson = "{\n" +
                "    \"name\": \"aaaa\",\n" +
                "    \"age\": 20,\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"company_id\": 1\n" +
                "}";

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andExpect(status().isCreated());

        List<Employee> employeeList = employeeRepository.findAll();
        assertEquals(1, employeeList.size());

        assertEquals("aaaa", employeeList.get(0).getName());
    }

    @Test
    void should_return_ok_when_delete_1_employee_given_1_employee() throws Exception{

        Employee employee = new Employee("aaa");
        int id = employeeRepository.save(employee).getId();

        mockMvc.perform(delete("/employees/" + id)).andExpect(status().isOk());

    }

    @Test
    void should_return_1_employee_when_update_1_employee_given_1_employee() throws Exception {
        String companyJson = "{\n" +
                "    \"companyName\": \"OOCL\"\n" +
                "}";
        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(companyJson));

        Employee employee = new Employee("bbb");
        int id = employeeRepository.save(employee).getId();
        String employeeJson = "{\n" +
                "    \"id\": "+id+",\n" +
                "    \"name\": \"aaaa\",\n" +
                "    \"age\": 20,\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"company_id\": 1\n" +
                "}";

        mockMvc.perform(put("/employees/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(employeeJson))
                .andExpect(status().isOk());

        List<Employee> employeeList = employeeRepository.findAll();

        assertEquals("aaaa", employeeList.get(0).getName());
    }

}
