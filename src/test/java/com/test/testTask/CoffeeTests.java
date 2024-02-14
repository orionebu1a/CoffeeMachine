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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
class CoffeeTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    void testCreateCup() throws Exception {
        Cup cup = new Cup();
        cup.setValue(0.4f);
        cup.setBalance(10);

        mockMvc.perform(post("/api/staff/cup/add")
                .content(objectMapper.writeValueAsString(cup))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.balance").value(cup.getBalance()))
                .andExpect(jsonPath("$.value").value(cup.getValue()));
    }

    @Transactional
    @Test
    void testCreateGrade() throws Exception {
        Grade grade = new Grade();
        grade.setName("Gentleman");
        grade.setBalance(4);
        grade.setRoast(10);

        mockMvc.perform(post("/api/staff/grade/add")
                .content(objectMapper.writeValueAsString(grade))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(grade.getName()))
                .andExpect(jsonPath("$.balance").value(grade.getBalance()))
                .andExpect(jsonPath("$.roast").value(grade.getRoast()));
    }


}

