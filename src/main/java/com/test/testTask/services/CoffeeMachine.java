package com.test.testTask.services;

import com.test.testTask.entities.*;
import com.test.testTask.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CoffeeMachine {
    @Autowired
    private final CupRepository cupRepository;
    @Autowired
    private final GradeRepository gradeRepository;
    @Autowired
    private final TypeRepository typeRepository;
    @Autowired
    private final GoodRepository goodRepository;
    @Autowired
    private final CoffeeRepository coffeeRepository;

    public Grade refillGrade(String grade, int count){
        Optional<Grade> optionalGrade = gradeRepository.findByName(grade);
        if (optionalGrade.isPresent()) {
            Grade foundGrade = optionalGrade.get();
            foundGrade.setBalance(foundGrade.getBalance() + 1);
            return gradeRepository.save(foundGrade);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Cup refillCup(String cup, int count){
        Optional<Cup> optionalCup = cupRepository.findByName(cup);
        if (optionalCup.isPresent()) {
            Cup foundCup = optionalCup.get();
            foundCup.setBalance(foundCup.getBalance() + 1);
            return cupRepository.save(foundCup);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Good refillGood(String good, int count){

    }

    public Type addType(String type, int count){

    }

    public void addCup(String type, int count){

    }

    public void addGrade(String type, int count){

    }

    public Coffee makeCoffee(String type, String grade, int sugarAmount) {
        if(type.equals("any") && grade.equals("any")){

        }
        else if(grade.equals("any")){

        }
        else{

        }
    }
}
