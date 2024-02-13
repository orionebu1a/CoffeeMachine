package com.test.testTask.controllers;

import com.test.testTask.dtos.CupDTO;
import com.test.testTask.dtos.GoodDTO;
import com.test.testTask.dtos.GradeDTO;
import com.test.testTask.dtos.TypeDTO;
import com.test.testTask.entities.*;
import com.test.testTask.services.CoffeeMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private CoffeeMachine coffeeMachine;

    @PostMapping("/type/add")
    public void createType(
            @RequestBody TypeDTO type
    ) {
        coffeeMachine.addType(new Type(type.getName()));
    }

    @GetMapping("/cup/refill")
    public Cup cupRefill(
            @RequestParam String cupName,
            @RequestParam int amount
    ) {
        return coffeeMachine.refillCup(cupName, amount);
    }

    @PostMapping("/cup/add")
    public void createCup(
            @RequestBody CupDTO cup
    ) {
        coffeeMachine.addCup(new Cup(cup.getName(), cup.getBalance()));
    }

    @GetMapping("/grade/refill")
    public Grade gradeRefill(
            @RequestParam String gradeName,
            @RequestParam int amount
    ) {
        return coffeeMachine.refillGrade(gradeName, amount);
    }

    @PostMapping("/grade/add")
    public void createGrade(
            @RequestBody GradeDTO grade
    ) {
        coffeeMachine.addGrade(new Grade(grade.getName(), grade.getBalance(), grade.getRoast()));
    }

    @GetMapping("/good/refill")
    public Good goodRefill(
            @RequestParam String goodName,
            @RequestParam int amount
    ) {
        return coffeeMachine.refillGood(goodName, amount);
    }

    @PostMapping("/good/add")
    public void createGood(
            @RequestBody GoodDTO good
    ) {
        coffeeMachine.addGood(new Good(good.getName(), good.getBalance()));
    }
}
