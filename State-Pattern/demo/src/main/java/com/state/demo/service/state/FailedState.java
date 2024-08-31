package com.state.demo.service.state;

import com.state.demo.model.Reminder;

import java.time.LocalDateTime;

public class FailedState implements ReminderState {

    @Override
    public String getStatus() {
        return "failed";
    }

    @Override
    public void modify(Reminder reminder, String text, LocalDateTime timestamp) {
        throw new UnsupportedOperationException("Cannot modify a failed reminder.");
    }

    @Override
    public void cancel(Reminder reminder) {
        throw new UnsupportedOperationException("Cannot cancel a failed reminder.");
    }

    @Override
    public void complete(Reminder reminder) {
        throw new UnsupportedOperationException("Cannot complete a failed reminder.");
    }
}
