package com.example.PlantCare.repository;

import com.example.PlantCare.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReminderRepo extends JpaRepository<Reminder, Long> {
    List<Reminder> findByDueDateAndDone(LocalDate date, Boolean done);
    List<Reminder> findByPlantId(Long plantId);
}
