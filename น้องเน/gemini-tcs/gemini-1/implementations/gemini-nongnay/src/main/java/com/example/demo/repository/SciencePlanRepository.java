package com.example.demo.repository;


import com.example.demo.model.SciencePlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SciencePlanRepository extends JpaRepository<SciencePlan, Integer> {
}
