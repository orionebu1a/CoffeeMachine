package com.test.testTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testTask.entities.Cup;
import com.test.testTask.entities.Good;
import com.test.testTask.entities.Grade;
import com.test.testTask.entities.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


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

    @Transactional
    @Test
    void testCreateType() throws Exception {
        Type type = new Type();
        type.setName("raf");

        mockMvc.perform(post("/api/staff/type/add")
                .content(objectMapper.writeValueAsString(type))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(type.getName()));
    }

    @Transactional
    @Test
    void testCreateGood() throws Exception {
        Good good = new Good();
        good.setName("sugar");
        good.setBalance(5);

        mockMvc.perform(post("/api/staff/good/add")
                .content(objectMapper.writeValueAsString(good))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(good.getName()))
                .andExpect(jsonPath("$.balance").value(good.getBalance()));
    }

    @Transactional
    @Test
    void testCreateResourcesSuccessfulMakeCoffee() throws Exception {
        mockMvc.perform(post("/api/staff/good/add")
                .content(objectMapper.writeValueAsString(new Good("sugar", 5)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/staff/grade/add")
                .content(objectMapper.writeValueAsString(new Grade("Robusta", 4, 10)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/staff/cup/add")
                .content(objectMapper.writeValueAsString(new Cup(0.4f, 10)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/staff/type/add")
                .content(objectMapper.writeValueAsString(new Type("raf")))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/client/make")
                .param("type", "raf")
                .param("grade", "Robusta")
                .param("size", "0.4")
                .param("sugarAmount", "2"))
                .andExpect(status().isOk());

    }

    @Transactional
    @Test
    void testCreateResourcesFailMakeCoffee() throws Exception {
        mockMvc.perform(get("/api/client/make")
                .param("type", "raf")
                .param("grade", "Robusta")
                .param("size", "0.4")
                .param("sugarAmount", "2"))
                .andExpect(status().isNotFound());
    }
}

