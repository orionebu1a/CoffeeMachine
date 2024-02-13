package com.test.testTask.controllers;

import com.test.testTask.dtos.CoffeeDTO;
import com.test.testTask.entities.Coffee;
import com.test.testTask.services.CoffeeMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private CoffeeMachine coffeeMachine;

    @GetMapping("/make")
    public CoffeeDTO prepareCoffee(
            @RequestParam(defaultValue = "any") String type,
            @RequestParam(defaultValue = "any") String grade,
            @RequestParam(defaultValue = "any") String size,
            @RequestParam(defaultValue = "0") int sugarAmount
    ) {
        return new CoffeeDTO(coffeeMachine.makeCoffee(type, grade, size, sugarAmount));
    }
}
