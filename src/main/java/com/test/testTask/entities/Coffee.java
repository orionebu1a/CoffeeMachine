package com.test.testTask.entities;

import jakarta.persistence.*;
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
    @JoinColumn(name = "cup_id")
    private Cup cup;

    @OneToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @OneToOne
    @JoinColumn(name = "type_id")
    private Type type;

    private LocalDateTime time;
}
