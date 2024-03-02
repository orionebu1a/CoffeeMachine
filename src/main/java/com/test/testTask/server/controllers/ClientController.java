package com.test.testTask.server.controllers;

import com.test.testTask.shared.domain.Coffee;
import com.test.testTask.shared.dtos.CoffeeDTO;
import com.test.testTask.shared.service.CoffeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@Api(tags = "Coffee client controller", value = "API для приготовления кофе")
@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private CoffeeService coffeeService;

    @ApiOperation(value = "Приготовить кофе")
    @GetMapping("/make")
    public ResponseEntity<CoffeeDTO> prepareCoffee(
            @RequestParam(defaultValue = "any") String type,
            @RequestParam(defaultValue = "any") String grade,
            @RequestParam(defaultValue = "any") String size,
            @RequestParam(defaultValue = "0") int sugarAmount
    ) {
        Coffee coffee;
        try{
            coffee = coffeeService.makeCoffee(type, grade, size, sugarAmount);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new CoffeeDTO(coffee));
    }
}
