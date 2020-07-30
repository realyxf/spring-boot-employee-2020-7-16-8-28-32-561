package com.thoughtworks.springbootemployee.integrationtest;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CompanyIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyRepository companyRepository;

    @AfterEach
    void tearDown(){
        companyRepository.deleteAll();
    }

    @Test
    void should_return_ok_when_find_company_given_1_company() throws Exception {

        mockMvc.perform(get("/companies")).andExpect(status().isOk());

    }

    @Test
    void should_return_2_companies_when_find_all_company_given_2_companies() throws Exception {
        Company company1 = new Company("OOCL");
        Company company2 = new Company("TW");
        companyRepository.save(company1);
        companyRepository.save(company2);

        mockMvc.perform(get("/companies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].companyName").value("OOCL"))
                .andExpect(jsonPath("[1].companyName").value("TW"));
    }

    @Test
    void should_return_1_company_when_add_1_company_given_1_company() throws Exception {
        String companyJson = "{\n" +
                "    \"companyName\": \"oocl\"\n" +
                "  }";

        mockMvc.perform(post("/companies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(companyJson))
                .andExpect(status().isCreated());

        List<Company> companyList = companyRepository.findAll();
        assertEquals(1,companyList.size());

        assertEquals("oocl",companyList.get(0).getCompanyName());
    }

    @Test
    void should_return_ok_when_delete_1_company_given_1_company(){

    }
}
