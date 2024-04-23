package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservingProgramRepository extends JpaRepository<ObservingPrograms, Long> {
    // Add custom query methods if needed
}
