package com.test.testTask.server.entities;

import javax.persistence.*;

import com.test.testTask.shared.domain.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class GradeImpl implements Grade {
    @Id
    private String name;
    private int roast;
    private int balance;
}

