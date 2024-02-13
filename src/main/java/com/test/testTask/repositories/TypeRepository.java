package com.test.testTask.repositories;
import com.test.testTask.entities.Coffee;
import com.test.testTask.entities.Grade;
import com.test.testTask.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findByName(String username);
    Optional<Type> findFirst();
}

