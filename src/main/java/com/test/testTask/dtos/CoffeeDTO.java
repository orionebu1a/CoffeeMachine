package com.test.testTask.dtos;

import com.test.testTask.entities.Coffee;
import com.test.testTask.entities.Cup;
import com.test.testTask.entities.Grade;
import com.test.testTask.entities.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoffeeDTO {
    private float cupValue;

    private String gradeName;

    private String typeName;

    private int sugar;

    private int time;

    public CoffeeDTO(Coffee coffee){
        cupValue = coffee.getCup().getValue();
        gradeName = coffee.getGrade().getName();
        typeName = coffee.getType().getName();
        sugar = coffee.getSugar();
        time = coffee.getTime().getSecond();
    }
}
