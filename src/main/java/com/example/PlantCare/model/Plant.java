package com.example.PlantCare.model;

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

    private String name;          // Plant ka naam (e.g. "Tulsi")

    private String nickname;      // Tumhara naam (e.g. "My Lucky Plant")

    private String species;       // Type (e.g. "Basil", "Cactus")

    private String location;      // "Indoor" ya "Outdoor"

    private String imageUrl;      // Optional photo link

    private LocalDate addedOn;    // Kab add kiya

    private Long userId;          // Kis user ka plant hai
}