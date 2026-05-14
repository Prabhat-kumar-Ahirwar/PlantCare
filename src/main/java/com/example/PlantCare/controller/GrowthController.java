package com.example.PlantCare.controller;

import com.example.PlantCare.model.GrowthLog;
import com.example.PlantCare.service.GrowthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/growth")
@RequiredArgsConstructor
public class GrowthController {

    private final GrowthService growthService;

    @PostMapping
    public ResponseEntity<GrowthLog> addLog(@Valid @RequestBody GrowthLog log) {
        return new ResponseEntity<>(growthService.addLog(log), HttpStatus.CREATED);
    }

    @GetMapping("/plant/{plantId}")
    public ResponseEntity<List<GrowthLog>> getLogs(@PathVariable Long plantId) {
        return ResponseEntity.ok(growthService.getLogs(plantId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrowthLog> updateLog(@PathVariable Long id, @Valid @RequestBody GrowthLog log) {
        return ResponseEntity.ok(growthService.updateLog(id, log));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        growthService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
