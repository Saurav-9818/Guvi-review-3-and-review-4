// src/main/java/com/fitness/tracker/model/Activity.java
package com.fitness.tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Activity name is required")
    private String name;

    @NotNull(message = "Calories burned is required")
    @Min(value = 1, message = "Calories burned must be greater than zero")
    private Integer caloriesBurned;

    @NotNull(message = "Duration in minutes is required")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer durationInMinutes;

    // Getters and Setters
}
