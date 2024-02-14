package com.test.testTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testTask.entities.Cup;
import com.test.testTask.entities.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class CoffeeIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateCup() throws Exception {
        Cup cup = new Cup();
        cup.setValue(0.4f);
        cup.setBalance(10);

        mockMvc.perform(post("/api/staff/cup/add")
                .content(objectMapper.writeValueAsString(cup))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.value").value(cup.getValue())); // проверяем ожидаемое значение
    }

    @Test
    void testAnyCoffeeMakeWithAddedResources() {

//        String gradeUrl = "http://localhost:8080/api/staff/grade/add";
//        Grade grade = new Grade("robusto", 8, 2);
//        ResponseEntity<Grade> gradeResponse = restTemplate.postForObject(gradeUrl, grade, ResponseEntity.class);
//        assertEquals(ResponeS, gradeResponse.getStatusCode());
    }
}

