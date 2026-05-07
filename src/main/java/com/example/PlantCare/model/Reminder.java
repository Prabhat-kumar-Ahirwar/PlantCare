package com.example.PlantCare.model;


import jakarta.persistence.*;
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
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Plant id is required")
    @Positive(message = "Plant id must be positive")
    private Long plantId;

    @NotBlank(message = "Reminder type is required")
    @Pattern(
            regexp = "water|fertilize|repot",
            message = "Reminder type must be water, fertilize, or repot"
    )
    private String reminderType;

    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Due date cannot be past date")
    private LocalDate dueDate;

    @Column(name = "done", columnDefinition = "boolean default false")
    private Boolean done = false;
}