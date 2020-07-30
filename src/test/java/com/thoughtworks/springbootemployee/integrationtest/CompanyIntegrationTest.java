package com.thoughtworks.springbootemployee.integrationtest;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.repository.CompanyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

        mockMvc.perform(MockMvcRequestBuilders.get("/companies")).andExpect(status().isOk());

    }

    @Test
    void should_return_1_company_when_add_1_company_given_1_company() throws Exception {
        String companyJson = "{\n" +
                "    \"companyName\": \"oocl\"\n" +
                "  }";

        mockMvc.perform(post("/companies").contentType(MediaType.APPLICATION_JSON).content(companyJson)).andExpect(status().isCreated());

        List<Company> companyList = companyRepository.findAll();
        assertEquals(1,companyList.size());

        assertEquals("oocl",companyList.get(0).getCompanyName());
    }

}
