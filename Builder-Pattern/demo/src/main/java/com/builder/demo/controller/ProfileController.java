package com.builder.demo.controller;

import com.builder.demo.model.Profile;
import com.builder.demo.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/set")
    public ResponseEntity<String> setProfile(@RequestBody Profile profile) {
        profileService.setProfile(profile);
        return new ResponseEntity<>("Profile set successfully", HttpStatus.OK);
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<Profile> getProfile(@PathVariable String username) {
        Profile profile = profileService.getProfile(username);
        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
