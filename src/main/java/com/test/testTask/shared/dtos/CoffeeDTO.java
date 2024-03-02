package com.test.testTask.shared.dtos;

import com.test.testTask.shared.domain.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoffeeDTO {
    private String cupValue;

    private String gradeName;

    private String typeName;

    private int sugar;

    private int time;

    public CoffeeDTO(Coffee coffee){
        cupValue = String.valueOf(coffee.getCup().getValue());
        gradeName = coffee.getGrade().getName();
        typeName = coffee.getType().getName();
        sugar = coffee.getSugar();
        time = coffee.getTime();
    }
}
