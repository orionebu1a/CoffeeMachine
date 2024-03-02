package com.test.testTask.server.controllers;


import com.test.testTask.shared.domain.Cup;
import com.test.testTask.shared.domain.Good;
import com.test.testTask.shared.domain.Grade;
import com.test.testTask.shared.domain.Type;
import com.test.testTask.shared.service.CoffeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Api(tags = "Coffee staff controller", value = "API для пополнения запасов кофе и ингредиентов")
@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private CoffeeService coffeeService;

    @ApiOperation(value = "Добавить новый тип кофе(Капучино, Латте)")
    @PostMapping("/type/add")
    public ResponseEntity<Type> createGrade(
            @RequestBody Type type
    ) {
        Type createdType;
        try{
            createdType = coffeeService.addType(type);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdType);
    }

    @ApiOperation(value = "Удалить тип кофе")
    @PostMapping("/type/remove")
    public ResponseEntity<String> removeType(
            @RequestParam String typeName
    ) {
        try{
            coffeeService.removeType(typeName);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Пополнить запас существующего объема стакана")
    @GetMapping("/cup/refill")
    public ResponseEntity<Cup> cupRefill(
            @RequestParam float value,
            @RequestParam int amount
    ) {
        Cup cup;
        try{
            cup = coffeeService.refillCup(value, amount);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cup);
    }

    @ApiOperation(value = "Добавить новый объем стакана")
    @PostMapping("/cup/add")
    public ResponseEntity<Cup> createCup(
            @RequestBody Cup cup
    ) {
        Cup createdCup;
        try{
            createdCup = coffeeService.addCup(cup);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdCup);
    }

    @ApiOperation(value = "Удалить объем сткана")
    @PostMapping("/cup/remove")
    public ResponseEntity<String> removeCup(
            @RequestParam float value
    ) {
        try{
            coffeeService.removeCup(value);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Пополнить запас существующего сорта кофе")
    @GetMapping("/grade/refill")
    public ResponseEntity<Grade> gradeRefill(
            @RequestParam String gradeName,
            @RequestParam int amount
    ) {
        Grade grade;
        try{
            grade = coffeeService.refillGrade(gradeName, amount);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grade);
    }

    @ApiOperation(value = "Добавить новый сорт кофе")
    @PostMapping("/grade/add")
    public ResponseEntity<Grade> createGrade(
            @RequestBody Grade grade
    ) {
        Grade createdGrade;
        try{
            createdGrade = coffeeService.addGrade(grade);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdGrade);
    }

    @ApiOperation(value = "Удалить сорт кофе")
    @PostMapping("/grade/remove")
    public ResponseEntity<String> removeGrade(
            @RequestParam String gradeName
    ) {
        try{
            coffeeService.removeGrade(gradeName);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Пополнить запас существующего ингредиента")
    @GetMapping("/good/refill")
    public ResponseEntity<Good> goodRefill(
            @RequestParam String goodName,
            @RequestParam int amount
    ) {
        Good good;
        try{
            good = coffeeService.refillGood(goodName, amount);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(good);
    }

    @ApiOperation(value = "Добавить новый тип ингредиента")
    @PostMapping("/good/add")
    public ResponseEntity<Good> createGood(
            @RequestBody Good good
    ) {
        Good createdGood;
        try{
            createdGood = coffeeService.addGood(good);
        }
        catch (IllegalAccessError e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(createdGood);
    }

    @ApiOperation(value = "Удалить тип ингредиента")
    @PostMapping("/good/remove")
    public ResponseEntity<String> removeGood(
            @RequestParam String goodName
    ) {
        try{
            coffeeService.removeGood(goodName);
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
