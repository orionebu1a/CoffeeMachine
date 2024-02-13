package com.test.testTask.entities;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "cup_value")
    private Cup cup;

    @OneToOne
    @JoinColumn(name = "grade_name")
    private Grade grade;

    @OneToOne
    @JoinColumn(name = "type_name")
    private Type type;

    private int sugar;

    private LocalDateTime time;
}
