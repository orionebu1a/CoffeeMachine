package com.test.testTask.shared.service;

import com.test.testTask.shared.domain.*;

import java.util.List;

public interface CoffeeService {

    Grade refillGrade(String gradeName, int count);

    Cup refillCup(float cupValue, int count);

    Good refillGood(String goodName, int count);

    Type addType(Type type);

    Cup addCup(Cup cup);

    Grade addGrade(Grade grade);

    Good addGood(Good good);

    Type findOrAnyType(String typeName);

    Grade findOrAnyGrade(String gradeName);

    Cup findOrAnyCup(String cupName);

    Coffee makeCoffee(String typeName, String gradeName, String cupName, int sugarAmount);

    void removeGood(String goodName);

    void removeGrade(String gradeName);

    void removeCup(float value);

    void removeType(String typeName);

    List<Coffee> getAllCoffee();
}
