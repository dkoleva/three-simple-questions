package com.three.simple.questions.backend.web;

import com.three.simple.questions.backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profiles")
    public List<UserProfileDTO> getProfile() {
        return profileService.getProfiles();
    }

    @PutMapping("/profiles")
    public UserProfileDTO save(@RequestBody UserProfileDTO userProfileDTO) {
        return profileService.saveUserProfiles(userProfileDTO);
    }
}
