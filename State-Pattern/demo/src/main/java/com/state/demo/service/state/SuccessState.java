package com.state.demo.service.state;

import com.state.demo.model.Reminder;

import java.time.LocalDateTime;

public class SuccessState implements ReminderState {

    @Override
    public String getStatus() {
        return "success";
    }

    @Override
    public void modify(Reminder reminder, String text, LocalDateTime timestamp) {
        throw new UnsupportedOperationException("Cannot modify a completed reminder.");
    }

    @Override
    public void cancel(Reminder reminder) {
        throw new UnsupportedOperationException("Cannot cancel a completed reminder.");
    }

    @Override
    public void complete(Reminder reminder) {
        // Already completed; no action
    }
}
