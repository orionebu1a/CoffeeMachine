package com.test.testTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.testTask.server.entities.CupImpl;
import com.test.testTask.server.entities.GoodImpl;
import com.test.testTask.server.entities.GradeImpl;
import com.test.testTask.server.entities.TypeImpl;
import com.test.testTask.shared.domain.Cup;
import com.test.testTask.shared.domain.Good;
import com.test.testTask.shared.domain.Grade;
import com.test.testTask.shared.domain.Type;
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
    void testCreateRefillRemoveCup() throws Exception {
        Cup cup = new CupImpl();
        cup.setValue(0.4f);
        cup.setBalance(10);

        mockMvc.perform(post("/api/staff/cup/add")
                .content(objectMapper.writeValueAsString(cup))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.balance").value(cup.getBalance()))
                .andExpect(jsonPath("$.value").value(cup.getValue()));

        mockMvc.perform(get("/api/staff/cup/refill")
                .param("value", String.valueOf(cup.getValue()))
                .param("amount", "1"))
                .andExpect(jsonPath("$.balance").value(cup.getBalance() + 1));

        mockMvc.perform(post("/api/staff/cup/remove")
                .param("value", String.valueOf(cup.getValue())))
                .andExpect(status().isOk());
    }

    @Transactional
    @Test
    void testCreateRefillRemoveGrade() throws Exception {
        Grade grade = new GradeImpl();
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

        mockMvc.perform(get("/api/staff/grade/refill")
                .param("gradeName", String.valueOf(grade.getName()))
                .param("amount", "1"))
                .andExpect(jsonPath("$.balance").value(grade.getBalance() + 1));

        mockMvc.perform(post("/api/staff/grade/remove")
                .param("gradeName", grade.getName()))
                .andExpect(status().isOk());
    }

    @Transactional
    @Test
    void testCreateRemoveType() throws Exception {
        Type type = new TypeImpl();
        type.setName("raf");

        mockMvc.perform(post("/api/staff/type/add")
                .content(objectMapper.writeValueAsString(type))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(type.getName()));

        mockMvc.perform(post("/api/staff/type/remove")
                .param("typeName", type.getName()))
                .andExpect(status().isOk());
    }

    @Transactional
    @Test
    void testCreateRefillRemoveGood() throws Exception {
        Good good = new GoodImpl();
        good.setName("sugar");
        good.setBalance(5);

        mockMvc.perform(post("/api/staff/good/add")
                .content(objectMapper.writeValueAsString(good))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(good.getName()))
                .andExpect(jsonPath("$.balance").value(good.getBalance()));

        mockMvc.perform(get("/api/staff/good/refill")
                .param("goodName", String.valueOf(good.getName()))
                .param("amount", "1"))
                .andExpect(jsonPath("$.balance").value(good.getBalance() + 1));

        mockMvc.perform(post("/api/staff/good/remove")
                .param("goodName", good.getName()))
                .andExpect(status().isOk());
    }

    @Transactional
    @Test
    void testCreateResourcesSuccessfulMakeCoffee() throws Exception {
        mockMvc.perform(post("/api/staff/good/add")
                .content(objectMapper.writeValueAsString(new GoodImpl("sugar", 5)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/staff/grade/add")
                .content(objectMapper.writeValueAsString(new GradeImpl("Robusta", 4, 10)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/staff/cup/add")
                .content(objectMapper.writeValueAsString(new CupImpl(0.4f, 10)))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mockMvc.perform(post("/api/staff/type/add")
                .content(objectMapper.writeValueAsString(new TypeImpl("raf")))
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

