package com.example.PlantCare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "growth_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrowthLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Plant ID is required")
    @Positive(message = "Plant ID must be positive")
    private Long plantId;

    private LocalDate date;

    @NotNull(message = "Height is required")
    @Positive(message = "Height must be positive")
    private Double heightCm;

    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;
}
