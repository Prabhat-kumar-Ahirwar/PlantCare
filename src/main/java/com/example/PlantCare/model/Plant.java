package com.example.PlantCare.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "plants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Plant name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    private String nickname;

    @NotBlank(message = "Species is required")
    private String species;

    @NotBlank(message = "Location is required")
    @Pattern(regexp = "Indoor|Outdoor", message = "Location must be Indoor or Outdoor")
    private String location;

    @Pattern(regexp = "^(http|https)://.*$", message = "Invalid image URL")
    private String imageUrl;

    private LocalDate addedOn;

    // userId will be set from JWT token in the future — kept as a plain field for now
    private Long userId;
}
