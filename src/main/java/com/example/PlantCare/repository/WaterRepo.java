package com.example.PlantCare.repository;

import com.example.PlantCare.model.WateringSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WaterRepo extends JpaRepository<WateringSchedule, Long> {
    Optional<WateringSchedule> findByPlantId(Long plantId);
}