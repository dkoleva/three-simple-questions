package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.web.UserProfileDTO;

import java.util.List;

public interface ProfileService {

    List<UserProfileDTO> getProfiles();

    UserProfileDTO saveUserProfiles(UserProfileDTO userProfileDTO);
}
