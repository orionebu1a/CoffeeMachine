package com.test.testTask.controllers;

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
    public void cupRefill(
            @RequestBody Type type
    ) {
        coffeeMachine.addType(type);
    }

    @GetMapping("/cup/refill")
    public Cup cupRefill(
            @RequestParam String cupName,
            @RequestParam int amount
    ) {
        return coffeeMachine.refillCup(cupName, amount);
    }

    @PostMapping("/cup/add")
    public void cupRefill(
            @RequestBody Cup cup
    ) {
        coffeeMachine.addCup(cup);
    }

    @GetMapping("/grade/refill")
    public Grade gradeRefill(
            @RequestParam String gradeName,
            @RequestParam int amount
    ) {
        return coffeeMachine.refillGrade(gradeName, amount);
    }

    @PostMapping("/grade/add")
    public void gradeRefill(
            @RequestBody Grade grade
    ) {
        coffeeMachine.addGrade(grade);
    }

    @GetMapping("/good/refill")
    public Good goodRefill(
            @RequestParam String goodName,
            @RequestParam int amount
    ) {
        return coffeeMachine.refillGood(goodName, amount);
    }

    @PostMapping("/good/add")
    public void goodRefill(
            @RequestBody Good good
    ) {
        coffeeMachine.addGood(good);
    }
}
