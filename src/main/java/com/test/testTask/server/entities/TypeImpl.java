package com.test.testTask.server.entities;

import javax.persistence.*;

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
public class TypeImpl implements Type {
    @Id
    private String name;
}


