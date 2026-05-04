package com.example.PlantCare.repository;

import com.example.PlantCare.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepo extends JpaRepository<Plant , Long> {

}
