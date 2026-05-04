package com.example.PlantCare.controller;

import com.example.PlantCare.model.WateringSchedule;
import com.example.PlantCare.service.WaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/watering")
@RequiredArgsConstructor
public class WateringController {

    private final WaterService waterService;

    @PostMapping
    public ResponseEntity<WateringSchedule> setSchedule(@RequestBody WateringSchedule schedule) {
        return ResponseEntity.ok(waterService.setSchedule(schedule));
    }

    @PutMapping("/{plantId}/water")
    public ResponseEntity<WateringSchedule> markWatered(@PathVariable Long plantId) {
        return ResponseEntity.ok(waterService.markWatered(plantId));
    }

    @GetMapping("/{plantId}")
    public ResponseEntity<WateringSchedule> getSchedule(@PathVariable Long plantId) {
        return ResponseEntity.ok(waterService.getSchedule(plantId));
    }
}