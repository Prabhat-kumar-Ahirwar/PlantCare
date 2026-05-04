package com.example.PlantCare.controller;

import com.example.PlantCare.model.Plant;
import com.example.PlantCare.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private static PlantService plantService;


    @PostMapping("/addplant")
    public ResponseEntity<Plant> AddingPlant(@RequestBody Plant plant){
        return ResponseEntity.ok(plantService.addPlant(plant));

    }
}
