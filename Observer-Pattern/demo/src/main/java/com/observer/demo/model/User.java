package com.observer.demo.model;

public class User {
    private String userId;
    private String name;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.username = builder.username;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.password = builder.password;
    }

    // Getters

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    // Builder Class
    public static class Builder {
        private String userId;
        private String name;
        private String username;
        private String email;
        private String phoneNumber;
        private String password;

        public Builder(String userId) {
            this.userId = userId;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
