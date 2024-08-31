package com.state.demo.controller;

import com.state.demo.model.Reminder;
import com.state.demo.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping
    public Reminder setReminder(@RequestBody ReminderRequest request) {
        return reminderService.setReminder(request.getText(), request.getTimestamp());
    }

    @GetMapping("/{id}")
    public Reminder getReminder(@PathVariable UUID id) {
        return reminderService.getReminder(id);
    }

    @GetMapping
    public Collection<Reminder> getAllReminders() {
        return reminderService.getAllReminders();
    }

    @PutMapping("/{id}")
    public Reminder modifyReminder(@PathVariable UUID id, @RequestBody ReminderRequest request) {
        return reminderService.modifyReminder(id, request.getText(), request.getTimestamp());
    }

    @PostMapping("/{id}/cancel")
    public Reminder cancelReminder(@PathVariable UUID id) {
        return reminderService.cancelReminder(id);
    }

    @PostMapping("/{id}/complete")
    public Reminder completeReminder(@PathVariable UUID id) {
        Reminder reminder = reminderService.getReminder(id);
        if (reminder != null) {
            reminder.complete();
        }
        return reminder;
    }

    public static class ReminderRequest {
        private String text;
        private LocalDateTime timestamp;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }
    }
}
