package com.example.PlantCare.service;

import com.example.PlantCare.model.Reminder;
import com.example.PlantCare.repository.ReminderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReminderService {

    private final ReminderRepo reminderRepo;

    public Reminder addReminder(Reminder reminder) {
        reminder.setDone(false);
        return reminderRepo.save(reminder);
    }

    public List<Reminder> getTodayReminders() {
        return reminderRepo.findByDueDateAndIsDone(LocalDate.now(), false);
    }

    public List<Reminder> getByPlant(Long plantId) {
        return reminderRepo.findByPlantId(plantId);
    }

    public Reminder markDone(Long id) {
        Reminder r = reminderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Reminder not found"));
        r.setDone(true);
        return reminderRepo.save(r);
    }
}