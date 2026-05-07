package com.example.PlantCare.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "plants")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Plant name is required")
    @Size(min = 2 ,max = 50 ,message = "Name must be between 2 and 50 characters")
    private String name;          // Plant ka naam (e.g. "Tulsi")

    private String nickname;

    @NotBlank(message = "Species is required")

    private String species;       // Type (e.g. "Basil", "Cactus")

    @NotBlank(message = "Location is required")
    @Pattern(
            regexp = "Indoor|Outdoor",
            message = "Location must be Indoor or Outdoor"
    )
    @NotBlank(message = "Location is required")
    @Pattern(
            regexp = "Indoor|Outdoor",
            message = "Location must be Indoor or Outdoor"
    )
    private String location;

    @Pattern(
            regexp = "^(http|https)://.*$",
            message = "Invalid image URL"
    )
    private String imageUrl;

    @PastOrPresent(message = "Added date cannot be future date")
    private LocalDate addedOn;

    @NotNull(message = "User ID is required")
    @Positive(message = "User ID must be positive")
    private Long userId;
}