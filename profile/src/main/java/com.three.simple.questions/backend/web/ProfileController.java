package com.three.simple.questions.backend.web;

import com.three.simple.questions.backend.service.ProfileNotFoundException;
import com.three.simple.questions.backend.service.ProfileService;
import com.three.simple.questions.backend.service.UserProfileWithQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileController {

    private final UserProfileWithQuestionService userProfileWithQuestionService;
    private final ProfileService profileService;

    @Autowired
    public ProfileController(UserProfileWithQuestionService userProfileWithQuestionService,
                             ProfileService profileService) {
        this.userProfileWithQuestionService = userProfileWithQuestionService;
        this.profileService = profileService;
    }

    @GetMapping("/profiles")
    public List<UserProfileWithQuestionsDTO> getProfiles(@RequestParam(required = false) String forUser) {
        if (forUser != null) {
            return userProfileWithQuestionService.getProfilesForUser(forUser);
        } else {
            return userProfileWithQuestionService.getProfiles();
        }
    }

    @GetMapping("/profiles/{identifier}")
    public UserProfileDTO getProfileByIdentifier(@PathVariable String identifier) throws Exception {
        return profileService.getProfileByIdentifier(identifier);
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
