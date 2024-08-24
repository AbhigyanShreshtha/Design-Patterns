package com.builder.demo.service.impl;

import com.builder.demo.model.Profile;
import com.builder.demo.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final Map<String, Profile> profileStore;

    public ProfileServiceImpl() {
        this.profileStore = new HashMap<>();
    }

    @Override
    public void setProfile(Profile profile) {
        profileStore.put(profile.getUsername(), profile);
    }

    @Override
    public Profile getProfile(String username) {
        return profileStore.get(username);
    }
}
