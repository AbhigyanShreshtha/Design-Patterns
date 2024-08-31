package com.state.demo.service.state;

import com.state.demo.model.Reminder;

import java.time.LocalDateTime;

public interface ReminderState {
    String getStatus();
    void modify(Reminder reminder, String text, LocalDateTime timestamp);
    void cancel(Reminder reminder);
    void complete(Reminder reminder);
}
