package com.example.PlantCare.controller;

import com.example.PlantCare.model.Reminder;
import com.example.PlantCare.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
@RequiredArgsConstructor
public class ReminderController {

    private final ReminderService reminderService;

    @PostMapping
    public ResponseEntity<Reminder> addReminder(@RequestBody Reminder reminder) {
        return ResponseEntity.ok(reminderService.addReminder(reminder));
    }

    @GetMapping("/today")
    public ResponseEntity<List<Reminder>> getToday() {
        return ResponseEntity.ok(reminderService.getTodayReminders());
    }

    @GetMapping("/plant/{plantId}")
    public ResponseEntity<List<Reminder>> getByPlant(@PathVariable Long plantId) {
        return ResponseEntity.ok(reminderService.getByPlant(plantId));
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<Reminder> markDone(@PathVariable Long id) {
        return ResponseEntity.ok(reminderService.markDone(id));
    }
}
