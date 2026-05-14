package com.example.PlantCare.controller;

import com.example.PlantCare.model.Reminder;
import com.example.PlantCare.service.ReminderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
@RequiredArgsConstructor
public class ReminderController {

    private final ReminderService reminderService;

    @PostMapping
    public ResponseEntity<Reminder> addReminder(@Valid @RequestBody Reminder reminder) {
        return new ResponseEntity<>(reminderService.addReminder(reminder), HttpStatus.CREATED);
    }

    @GetMapping("/today")
    public ResponseEntity<List<Reminder>> getTodayReminders() {
        return ResponseEntity.ok(reminderService.getTodayReminders());
    }

    @GetMapping("/plant/{plantId}")
    public ResponseEntity<List<Reminder>> getRemindersByPlant(@PathVariable Long plantId) {
        return ResponseEntity.ok(reminderService.getRemindersByPlant(plantId));
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<Reminder> markDone(@PathVariable Long id) {
        return ResponseEntity.ok(reminderService.markDone(id));
    }
}
