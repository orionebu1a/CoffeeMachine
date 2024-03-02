package com.test.testTask.server.entities;

import javax.persistence.*;


import com.test.testTask.shared.domain.Cup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class CupImpl implements Cup {
    @Id
    private float value;
    private int balance;
}
