package com.example.PlantCare.repository;

import com.example.PlantCare.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepo extends JpaRepository<Plant, Long> {
    List<Plant> findByUserId(Long userId);
}
