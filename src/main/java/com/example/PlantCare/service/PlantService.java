package com.example.PlantCare.service;

import com.example.PlantCare.model.Plant;
import com.example.PlantCare.repository.PlantRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlantService {



    private final PlantRepo plantRepo;

    public PlantService(PlantRepo plantRepo) {
        this.plantRepo = plantRepo;
    }


    public Plant addPlant(Plant plant) {
        plant.setAddedOn(LocalDate.now());
        return plantRepo.save(plant);
    }

    public List<Plant> getPlant(){
        return plantRepo.findAll();
    }

    public Plant updatePlant(Long id, Plant updatedPlant) {
        Plant existing = getPlantById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));

        existing.setName(updatedPlant.getName());
        existing.setNickname(updatedPlant.getNickname());
        existing.setSpecies(updatedPlant.getSpecies());
        existing.setLocation(updatedPlant.getLocation());
        existing.setImageUrl(updatedPlant.getImageUrl());

        return plantRepo.save(existing);
    }
    public Optional<Plant> getPlantById(Long id) {
        return plantRepo.findById(id);
    }

}
