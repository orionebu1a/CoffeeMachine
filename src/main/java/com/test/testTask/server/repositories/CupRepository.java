package com.test.testTask.server.repositories;
import com.test.testTask.shared.domain.Cup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CupRepository extends JpaRepository<Cup, Long> {
    Optional<Cup> findByValue(float value);
    Optional<Cup> findFirstByBalanceGreaterThan(int quantity);
    void deleteByValue(float value);
}
