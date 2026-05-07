package com.example.PlantCare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrowthLog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Plant ID is required")
    @Positive(message = "Plant ID must be positive")
    private Long plantId;

    @NotNull(message = "Date is required")
    @PastOrPresent(message = "Added date cannot be future date")
    private LocalDate date;

    @NotNull(message = "Height is required")
    @Positive(message = "Height must be positive")
    private Double heightCm;

    @Size(max = 500, message = "Notes cannot exceed 500 characters")
    private String notes;
}