package com.state.demo.model;

import com.state.demo.service.state.ReminderState;
import com.state.demo.service.state.PendingState;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reminder {

    private UUID id;
    private String text;
    private LocalDateTime timestamp;
    private ReminderState state;

    public Reminder(String text, LocalDateTime timestamp) {
        this.id = UUID.randomUUID();
        this.text = text;
        this.timestamp = timestamp;
        this.state = new PendingState(); // Initialize with Pending state
    }

    public UUID getId() {
        return id;
    }

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

    public String getStatus() {
        return state.getStatus();
    }

    public void setState(ReminderState state) {
        this.state = state;
    }

    public void modify(String text, LocalDateTime timestamp) {
        state.modify(this, text, timestamp);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void complete() {
        state.complete(this);
    }
}
