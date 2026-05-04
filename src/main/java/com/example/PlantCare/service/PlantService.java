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

    public ResponseEntity<List<Plant>> getPlant(){
        return new ResponseEntity<>(plantRepo.findAll() , HttpStatus.OK);
    }

}
