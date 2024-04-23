package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScienceObserverRepository extends JpaRepository<ScienceObserver, Long> {
    // Add custom query methods if needed
}
