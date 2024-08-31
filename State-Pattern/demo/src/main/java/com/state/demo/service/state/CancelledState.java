package com.state.demo.service.state;

import com.state.demo.model.Reminder;

import java.time.LocalDateTime;

public class CancelledState implements ReminderState {

    @Override
    public String getStatus() {
        return "cancelled";
    }

    @Override
    public void modify(Reminder reminder, String text, LocalDateTime timestamp) {
        throw new UnsupportedOperationException("Cannot modify a cancelled reminder.");
    }

    @Override
    public void cancel(Reminder reminder) {
        // Already cancelled; no action
    }

    @Override
    public void complete(Reminder reminder) {
        throw new UnsupportedOperationException("Cannot complete a cancelled reminder.");
    }
}
