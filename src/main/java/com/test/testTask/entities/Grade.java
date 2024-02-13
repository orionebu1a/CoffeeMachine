package com.test.testTask.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int roast;
    private int balance;

    public Grade(String name, int balance, int roast) {
        this.balance = balance;
        this.name = name;
        this.roast = roast;
    }
}

