package com.test.testTask.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float size;
    private int balance;
}
