package com.example.PlantCare.repository;

import com.example.PlantCare.model.GrowthLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrowthRepo extends JpaRepository<GrowthLog, Long> {
    List<GrowthLog> findByPlantIdOrderByDateDesc(Long plantId);
}
