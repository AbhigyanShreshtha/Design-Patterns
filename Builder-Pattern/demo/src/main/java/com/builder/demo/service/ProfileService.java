package com.builder.demo.service;

import com.builder.demo.model.Profile;

public interface ProfileService {
    void setProfile(Profile profile);
    Profile getProfile(String username);
}
