package com.test.testTask.server.repositories;
import com.test.testTask.shared.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    Optional<Grade> findByName(String gradeName);
    Optional<Grade> findFirstByBalanceGreaterThan(int quantity);
    void deleteByName(String name);
}
