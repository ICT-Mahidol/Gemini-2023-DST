package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronomerRepository extends JpaRepository<Astronomer, Long> {
    // Add custom query methods if needed
}
