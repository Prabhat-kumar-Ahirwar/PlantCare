package com.example.PlantCare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reminders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Plant ID is required")
    @Positive(message = "Plant ID must be positive")
    private Long plantId;

    @NotBlank(message = "Reminder type is required")
    @Pattern(regexp = "water|fertilize|repot", message = "Reminder type must be: water, fertilize, or repot")
    private String reminderType;

    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDate dueDate;

    @Builder.Default
    private Boolean done = false;
}
