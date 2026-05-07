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
public class WateringSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "PlantId must be required")
    @Positive(message = "PlantId must be positive")
    private Long plantId;

    @Positive(message = "Frequency must be positive")
    private int frequencyInDays;

    @PastOrPresent(message = "Last watered date cannot be future")
    private LocalDate lastWateredAt;

    @FutureOrPresent(message = "Next watering date cannot be past")
    private LocalDate nextWateringAt;
}
