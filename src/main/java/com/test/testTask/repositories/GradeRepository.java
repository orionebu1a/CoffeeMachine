package com.test.testTask.repositories;
import com.test.testTask.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    Optional<Grade> findByName(String gradeName);
    Optional<Grade> findFirstByBalanceGreaterThan(int quantity);
}
