package com.example.PlantCare.service;

import com.example.PlantCare.model.GrowthLog;
import com.example.PlantCare.repository.GrowthRepo;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrowthService {

    private final GrowthRepo growthRepo;

    public GrowthLog addLog(GrowthLog log) {
        log.setDate(LocalDate.now());
        return growthRepo.save(log);
    }

    public List<GrowthLog> getLogs(Long plantId) {
        return growthRepo.findByPlantIdOrderByDateDesc(plantId);
    }

    public void deleteLog(Long id) {
        growthRepo.deleteById(id);
    }

    public GrowthLog updateLog(Long id, GrowthLog updatedLog) {

        GrowthLog existingLog = growthRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"));

        existingLog.setPlantId(updatedLog.getPlantId());
        existingLog.setDate(updatedLog.getDate());
        existingLog.setHeightCm(updatedLog.getHeightCm());
        existingLog.setNotes(updatedLog.getNotes());

        return growthRepo.save(existingLog);
    }
}