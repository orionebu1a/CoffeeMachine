package com.test.testTask.server.repositories;

import com.test.testTask.shared.domain.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodRepository extends JpaRepository<Good, Long> {
    Optional<Good> findByName(String goodName);
    void deleteByName(String name);
}

