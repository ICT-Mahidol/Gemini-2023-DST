package com.gemini.pj.phase2.repository;

import  com.gemini.pj.phase2.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}