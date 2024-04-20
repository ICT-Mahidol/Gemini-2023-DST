package com.example.gemini.Model;

import org.springframework.data.repository.CrudRepository;

public interface SciencePlanRepository extends CrudRepository<SciencePlanModelGDDG, Integer> {
    SciencePlanModelGDDG findByplanNo(int planNo);
}
