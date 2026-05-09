package com.example.PlantCare.service;

import com.example.PlantCare.ExceptionHandler.PlantNotFoundException;
import com.example.PlantCare.model.Plant;
import com.example.PlantCare.repository.PlantRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepo plantRepo;

    // Add
    public Plant addPlant(Plant plant) {
        plant.setAddedOn(LocalDate.now());
        return plantRepo.save(plant);
    }

    // Get all
    public List<Plant> getPlant() {
        return plantRepo.findAll();
    }

    // Get by ID
    public Plant getPlantById(Long id) {
        return plantRepo.findById(id)
                .orElseThrow(() -> new PlantNotFoundException("Plant not found with id: " + id));
    }

    // Get by userId
    public List<Plant> getPlantsByUser(Long userId) {
        return plantRepo.findByUserId(userId);
    }

    // Update
    public Plant updatePlant(Long id, Plant updatedPlant) {
        Plant existing = getPlantById(id);
        existing.setName(updatedPlant.getName());
        existing.setNickname(updatedPlant.getNickname());
        existing.setSpecies(updatedPlant.getSpecies());
        existing.setLocation(updatedPlant.getLocation());
        existing.setImageUrl(updatedPlant.getImageUrl());
        return plantRepo.save(existing);
    }

    // Delete
    public void deletePlant(Long id) {

        if (!plantRepo.existsById(id)) {
            throw new PlantNotFoundException(
                    "Plant not found with id : " + id
            );
        }

        plantRepo.deleteById(id);
    }
}