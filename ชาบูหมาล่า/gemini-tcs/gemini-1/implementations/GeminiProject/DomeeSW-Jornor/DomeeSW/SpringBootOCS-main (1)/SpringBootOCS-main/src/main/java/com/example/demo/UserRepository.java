package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.User; // Import the correct User class from your project's package

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
