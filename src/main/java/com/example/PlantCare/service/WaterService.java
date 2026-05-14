package com.example.PlantCare.service;

import com.example.PlantCare.exception.ScheduleNotFoundException;
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
        WateringSchedule schedule = waterRepo.findByPlantId(plantId)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule not found for plant id: " + plantId));
        schedule.setLastWateredAt(LocalDate.now());
        schedule.setNextWateringAt(LocalDate.now().plusDays(schedule.getFrequencyInDays()));
        return waterRepo.save(schedule);
    }

    public WateringSchedule getSchedule(Long plantId) {
        return waterRepo.findByPlantId(plantId)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule not found for plant id: " + plantId));
    }
}
