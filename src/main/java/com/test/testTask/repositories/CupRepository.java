package com.test.testTask.repositories;
import com.test.testTask.entities.Cup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupRepository extends JpaRepository<Cup, Long> {
    Optional<Cup> findByName(String cupName);
    Optional<Cup> findFirstByBalanceGreaterThan(int quantity);
}
