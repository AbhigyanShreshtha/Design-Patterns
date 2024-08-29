package com.decorator.demo.model;

import java.util.UUID;

public class BankAccount {
    private final String userName;
    private final UUID userId;
    private final int bankBalance;
    private final String phoneNumber;
    private final String email;

    private BankAccount(Builder builder) {
        this.userName = builder.userName;
        this.userId = builder.userId;
        this.bankBalance = builder.bankBalance;
        this.phoneNumber = builder.phoneNumber;
        this.email = builder.email;
    }

    public static class Builder {//Builder Pattern
        private String userName;
        private UUID userId;
        private int bankBalance;
        private String phoneNumber;
        private String email;

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder bankBalance(int bankBalance) {
            this.bankBalance = bankBalance;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }

    // Getters

    public String getUserName() {
        return userName;
    }

    public UUID getUserId() {
        return userId;
    }

    public int getBankBalance() {
        return bankBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
