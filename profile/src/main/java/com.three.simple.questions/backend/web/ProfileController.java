package com.three.simple.questions.backend.web;

import com.three.simple.questions.backend.service.ProfileNotFoundException;
import com.three.simple.questions.backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/profiles")
    public List<UserProfileDTO> getProfiles(@RequestParam(required = false) String forUser) {
        if (forUser != null) {
            return profileService.getProfilesForUser();
        } else {
            return profileService.getProfiles();
        }
    }

    @GetMapping("/profiles/{identifier}")
    public UserProfileDTO getProfileByIdentifier(@PathVariable String identifier) throws Exception {
        return profileService.getProfileByIdentifier(identifier);
    }

    @PutMapping("/profiles/{userGuid}")
    public String saveMatchedUserGuids(@PathVariable String userGuid, @RequestBody String matchedUserGuid) {
        profileService.saveMatchedUserProfile(userGuid, matchedUserGuid);
        return matchedUserGuid;
    }

    @PutMapping("/profiles")
    public UserProfileDTO save(@RequestBody UserProfileDTO userProfileDTO) {
        return profileService.saveUserProfiles(userProfileDTO);
    }

    @ExceptionHandler(ProfileNotFoundException.class)
    public ResponseEntity<String> getResponse() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
