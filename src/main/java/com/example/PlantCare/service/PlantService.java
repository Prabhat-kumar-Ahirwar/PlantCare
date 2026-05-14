package com.example.PlantCare.service;

import com.example.PlantCare.exception.PlantNotFoundException;
import com.example.PlantCare.model.Plant;
import com.example.PlantCare.repository.PlantRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepo plantRepo;

    public Plant addPlant(Plant plant) {
        plant.setAddedOn(LocalDate.now());
        return plantRepo.save(plant);
    }

    public List<Plant> getAllPlants() {
        return plantRepo.findAll();
    }

    public Plant getPlantById(Long id) {
        return plantRepo.findById(id)
                .orElseThrow(() -> new PlantNotFoundException("Plant not found with id: " + id));
    }

    public List<Plant> getPlantsByUser(Long userId) {
        return plantRepo.findByUserId(userId);
    }

    public Plant updatePlant(Long id, Plant updated) {
        Plant existing = getPlantById(id);
        existing.setName(updated.getName());
        existing.setNickname(updated.getNickname());
        existing.setSpecies(updated.getSpecies());
        existing.setLocation(updated.getLocation());
        existing.setImageUrl(updated.getImageUrl());
        return plantRepo.save(existing);
    }

    public void deletePlant(Long id) {
        if (!plantRepo.existsById(id)) {
            throw new PlantNotFoundException("Plant not found with id: " + id);
        }
        plantRepo.deleteById(id);
    }
}
