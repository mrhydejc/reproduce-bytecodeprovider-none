package com.example.reproducer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherEntityRepository extends JpaRepository<OtherEntity, Long> {
}
