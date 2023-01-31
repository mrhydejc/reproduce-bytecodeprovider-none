package com.example.reproducer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OneEntityRepository extends JpaRepository<OneEntity, Long> {
}
