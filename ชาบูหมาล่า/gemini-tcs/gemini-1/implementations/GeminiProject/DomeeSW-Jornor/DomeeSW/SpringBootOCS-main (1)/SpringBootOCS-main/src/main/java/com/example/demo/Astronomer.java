package com.example.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "astronomers")
public class Astronomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    // Add more fields as needed

    // Getters and setters
}
