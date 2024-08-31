package com.state.demo.service.state;

import com.state.demo.model.Reminder;

import java.time.LocalDateTime;

public class PendingState implements ReminderState {

    @Override
    public String getStatus() {
        return "pending";
    }

    @Override
    public void modify(Reminder reminder, String text, LocalDateTime timestamp) {
        reminder.setText(text);
        reminder.setTimestamp(timestamp);
    }

    @Override
    public void cancel(Reminder reminder) {
        reminder.setState(new CancelledState());
    }

    @Override
    public void complete(Reminder reminder) {
        reminder.setState(new SuccessState());
    }
}
