package com.example.PlantCare.repository;

import com.example.PlantCare.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReminderRepo extends JpaRepository<Reminder, Long> {
    List<Reminder> findByDueDateAndIsDone(LocalDate date, boolean isDone);
    List<Reminder> findByPlantId(Long plantId);
}