package com.Arc.FitnessApp.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// FIRST TIME USING LAMBOK SO LOTS OF ANNOTATIONS
@Entity
@Table(name = "users")
@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with 1 argument for each field
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Column must be unique and not null.
    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    // Builder.Deafaults sets deafault value if no value is provided.
    @Builder.Default
    private Integer calorieGoal = 2000;

    @Builder.Default
    private Integer proteinGoal = 150;

    @Builder.Default
    private LocalDate createdAt = LocalDate.now();


}
