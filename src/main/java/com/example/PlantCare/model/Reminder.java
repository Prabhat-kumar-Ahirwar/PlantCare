package com.example.PlantCare.model;


import jakarta.persistence.*;
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

    private Long plantId;
    private String reminderType;  // "water", "fertilize", "repot"
    private LocalDate dueDate;
    @Column(name = "done", columnDefinition = "boolean default false")
    private Boolean done = false;

}