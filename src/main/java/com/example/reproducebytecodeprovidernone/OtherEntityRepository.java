package com.example.reproducebytecodeprovidernone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherEntityRepository extends JpaRepository<OtherEntityLazyLoaded, Long> {
}
