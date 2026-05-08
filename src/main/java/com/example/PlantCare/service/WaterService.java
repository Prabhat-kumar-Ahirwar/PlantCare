package com.example.PlantCare.service;

import com.example.PlantCare.ExceptionHandler.ResourceNotFoundException;
import com.example.PlantCare.model.WateringSchedule;
import com.example.PlantCare.repository.WaterRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WaterService {

    private final WaterRepo waterRepo;

    public WateringSchedule setSchedule(WateringSchedule schedule) {
        schedule.setNextWateringAt(
                schedule.getLastWateredAt().plusDays(schedule.getFrequencyInDays())
        );
        return waterRepo.save(schedule);
    }

    public WateringSchedule markWatered(Long plantId) {
        WateringSchedule ws = waterRepo.findByPlantId(plantId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));
        ws.setLastWateredAt(LocalDate.now());
        ws.setNextWateringAt(LocalDate.now().plusDays(ws.getFrequencyInDays()));
        return waterRepo.save(ws);
    }

    public WateringSchedule getSchedule(Long plantId) {
        return waterRepo.findByPlantId(plantId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));
    }
}