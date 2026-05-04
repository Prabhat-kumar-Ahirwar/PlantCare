package com.example.PlantCare.controller;

import com.example.PlantCare.model.GrowthLog;
import com.example.PlantCare.service.GrowthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/growth")
@RequiredArgsConstructor
public class GrowthController {

    private final GrowthService growthService;

    @PostMapping
    public ResponseEntity<GrowthLog> addLog(@RequestBody GrowthLog log) {
        return ResponseEntity.ok(growthService.addLog(log));
    }

    @GetMapping("/{plantId}")
    public ResponseEntity<List<GrowthLog>> getLogs(@PathVariable Long plantId) {
        return ResponseEntity.ok(growthService.getLogs(plantId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLog(@PathVariable Long id) {
        growthService.deleteLog(id);
        return ResponseEntity.ok("Log deleted!");
    }
}