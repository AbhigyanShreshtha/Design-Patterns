package com.state.demo.service;

import com.state.demo.model.Reminder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReminderService {

    private final Map<UUID, Reminder> reminders = new HashMap<>();

    public Reminder setReminder(String text, LocalDateTime timestamp) {
        Reminder reminder = new Reminder(text, timestamp);
        reminders.put(reminder.getId(), reminder);
        return reminder;
    }

    public Reminder getReminder(UUID id) {
        return reminders.get(id);
    }

    public Collection<Reminder> getAllReminders() {
        return reminders.values();
    }

    public Reminder modifyReminder(UUID id, String text, LocalDateTime timestamp) {
        Reminder reminder = reminders.get(id);
        if (reminder != null) {
            reminder.modify(text, timestamp);
        }
        return reminder;
    }

    public Reminder cancelReminder(UUID id) {
        Reminder reminder = reminders.get(id);
        if (reminder != null) {
            reminder.cancel();
        }
        return reminder;
    }
}
