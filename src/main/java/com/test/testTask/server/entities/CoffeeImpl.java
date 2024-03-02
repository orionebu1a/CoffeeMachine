package com.test.testTask.server.entities;


import javax.persistence.*;

import com.test.testTask.shared.domain.Coffee;
import com.test.testTask.shared.domain.Cup;
import com.test.testTask.shared.domain.Grade;
import com.test.testTask.shared.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CoffeeImpl implements Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "cup_value")
    private CupImpl cup;

    @OneToOne
    @JoinColumn(name = "grade_name")
    private GradeImpl grade;

    @OneToOne
    @JoinColumn(name = "type_name")
    private TypeImpl type;

    private int sugar;

    private int time;

    @Override
    public void setCup(Cup cup) {
        this.cup = (CupImpl) cup;
    }

    @Override
    public void setGrade(Grade grade) {
        this.grade = (GradeImpl) grade;
    }

    @Override
    public void setType(Type type) {
        this.type = (TypeImpl) type;
    }

    @Override
    public void setTime(int time) {
        this.time = time;
    }
}
