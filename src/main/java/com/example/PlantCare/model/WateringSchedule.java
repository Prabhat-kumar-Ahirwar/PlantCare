package com.example.PlantCare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "watering_schedules")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WateringSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Plant ID is required")
    @Positive(message = "Plant ID must be positive")
    private Long plantId;

    @NotNull(message = "Frequency is required")
    @Positive(message = "Frequency must be positive")
    private Integer frequencyInDays;

    @PastOrPresent(message = "Last watered date cannot be in the future")
    private LocalDate lastWateredAt;

    private LocalDate nextWateringAt;
}
