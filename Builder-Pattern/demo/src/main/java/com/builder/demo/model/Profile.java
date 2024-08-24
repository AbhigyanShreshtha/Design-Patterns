package com.builder.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Profile.ProfileBuilder.class)
public class Profile {
    private final String name;
    private final String email;
    private final String username;
    private final String password;

    private Profile(ProfileBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class ProfileBuilder {
        private String name;
        private String email;
        private String username;
        private String password;

        public ProfileBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProfileBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ProfileBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public ProfileBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }
}
