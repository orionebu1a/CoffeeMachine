package com.test.testTask.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.test.testTask.server.entities.*;
import com.test.testTask.server.repositories.*;
import com.test.testTask.shared.domain.*;
import com.test.testTask.shared.service.CoffeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.annotation.WebServlet;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@WebServlet("/gwt-rpc/yourGwtRpcService")
public class CoffeeServiceImpl extends RemoteServiceServlet implements CoffeeService {

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

    public Grade refillGrade(String gradeName, int count) {
        Optional<Grade> optionalGrade = gradeRepository.findByName(gradeName);
        if (optionalGrade.isPresent()) {
            Grade foundGrade = optionalGrade.get();
            foundGrade.setBalance(foundGrade.getBalance() + count);
            return gradeRepository.save(foundGrade);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Cup refillCup(float cupValue, int count) {
        Optional<Cup> optionalCup = cupRepository.findByValue(cupValue);
        if (optionalCup.isPresent()) {
            Cup foundCup = optionalCup.get();
            foundCup.setBalance(foundCup.getBalance() + count);
            return cupRepository.save(foundCup);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Good refillGood(String goodName, int count) {
        Optional<Good> optionalGood = goodRepository.findByName(goodName);
        if (optionalGood.isPresent()) {
            Good foundGood = optionalGood.get();
            foundGood.setBalance(foundGood.getBalance() + count);
            return goodRepository.save(foundGood);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Type addType(Type type) {
        if(typeRepository.findByName(type.getName()).isPresent()){
            throw new IllegalArgumentException();
        }
        return typeRepository.save(type);
    }

    public Cup addCup(Cup cup) {
        if(cupRepository.findByValue(cup.getValue()).isPresent()){
            throw new IllegalArgumentException();
        }
        return cupRepository.save(cup);
    }

    public Grade addGrade(Grade grade) {
        if(gradeRepository.findByName(grade.getName()).isPresent()){
            throw new IllegalArgumentException();
        }
        return gradeRepository.save(grade);
    }

    public Good addGood(Good good) {
        if(goodRepository.findByName(good.getName()).isPresent()){
            throw new IllegalArgumentException();
        }
        return goodRepository.save(good);
    }

    public Type findOrAnyType(String typeName){
        Optional<Type> optionalType;
        if (typeName.equals("any")) {
            optionalType = typeRepository.findRandomType();
        } else {
            optionalType = typeRepository.findByName(typeName);
        }
        if (!optionalType.isPresent()) {
            throw new EntityNotFoundException();
        }
        return optionalType.get();
    }

    public Grade findOrAnyGrade(String gradeName){
        Optional<Grade> optionalGrade;
        if (gradeName.equals("any")) {
            optionalGrade = gradeRepository.findFirstByBalanceGreaterThan(0);
        } else {
            optionalGrade = gradeRepository.findByName(gradeName);
        }
        if (!optionalGrade.isPresent()) {
            throw new EntityNotFoundException();
        }
        return optionalGrade.get();
    }

    public Cup findOrAnyCup(String cupName){
        Optional<Cup> optionalCup;
        if (cupName.equals("any")) {
            optionalCup = cupRepository.findFirstByBalanceGreaterThan(0);
        } else {
            optionalCup = cupRepository.findByValue(Float.parseFloat(cupName));
        }
        if (!optionalCup.isPresent()) {
            throw new EntityNotFoundException();
        }
        return optionalCup.get();
    }

    public Coffee makeCoffee(String typeName, String gradeName, String cupName, int sugarAmount) {
        Type type = findOrAnyType(typeName);
        Grade grade = findOrAnyGrade(gradeName);
        Cup cup = findOrAnyCup(cupName);

        if(sugarAmount > 0){
            Optional<Good> optionalGood = goodRepository.findByName("sugar");
            if (!optionalGood.isPresent()) {
                throw new EntityNotFoundException();
            }
            Good good = optionalGood.get();
            if (good.getBalance() - sugarAmount < 0) {
                throw new EntityNotFoundException();
            } else {
                good.setBalance(good.getBalance() - sugarAmount);
            }
        }

        grade.setBalance(grade.getBalance() - 1);
        cup.setBalance(cup.getBalance() - 1);

        Coffee coffee = new CoffeeImpl();
        coffee.setCup(cup);
        coffee.setGrade(grade);
        coffee.setType(type);
        coffee.setSugar(sugarAmount);
        coffee.setTime(LocalDateTime.now().getSecond());
        return coffeeRepository.save(coffee);
    }

    public void removeGood(String goodName) {
        if(!goodRepository.findByName(goodName).isPresent()){
            throw new IllegalArgumentException();
        }
        goodRepository.deleteByName(goodName);
    }

    public void removeGrade(String gradeName) {
        if(!gradeRepository.findByName(gradeName).isPresent()){
            throw new IllegalArgumentException();
        }
        gradeRepository.deleteByName(gradeName);
    }

    public void removeCup(float value) {
        if(!cupRepository.findByValue(value).isPresent()){
            throw new IllegalArgumentException();
        }
        cupRepository.deleteByValue(value);
    }

    public void removeType(String typeName) {
        if(!typeRepository.findByName(typeName).isPresent()){
            throw new IllegalArgumentException();
        }
        typeRepository.deleteByName(typeName);
    }

    //TODO
    @Override
    public List<Coffee> getAllCoffee() {
        return null;
    }
}

