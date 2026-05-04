package com.example.PlantCare.repository;

import com.example.PlantCare.model.GrowthLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrowthRepo extends JpaRepository<GrowthLog, Long> {
    List<GrowthLog> findByPlantIdOrderByDateDesc(Long plantId);
}