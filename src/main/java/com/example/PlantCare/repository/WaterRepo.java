package com.example.PlantCare.repository;

import com.example.PlantCare.model.WateringSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaterRepo extends JpaRepository<WateringSchedule, Long> {
    Optional<WateringSchedule> findByPlantId(Long plantId);
}
