package com.example.demo.repository;

import com.example.demo.model.ObservingProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservingProgramRepository extends JpaRepository<ObservingProgram, Integer> {
}
