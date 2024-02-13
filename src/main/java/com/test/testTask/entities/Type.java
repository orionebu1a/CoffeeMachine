package com.test.testTask.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Type {
    @Id
    private String name;

    public Type(String name) {
        this.name = name;
    }
}


