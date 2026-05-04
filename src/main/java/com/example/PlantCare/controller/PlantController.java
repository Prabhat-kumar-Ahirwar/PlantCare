package com.example.PlantCare.controller;

import com.example.PlantCare.model.Plant;
import com.example.PlantCare.service.PlantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlantController {

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    private final  PlantService plantService;


    @PostMapping("/addplant")
    public ResponseEntity<Plant> AddingPlant(@RequestBody Plant plant){
        return ResponseEntity.ok(plantService.addPlant(plant));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Plant>> getAllPlant() {
        return new ResponseEntity<List<Plant>>(plantService.getPlant(), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id , @RequestBody Plant plant){
        return ResponseEntity.ok(plantService.updatePlant(id, plant));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Plant>> getPlantById(@PathVariable Long id){
        return ResponseEntity.ok(plantService.getPlantById(id));
    }
}
