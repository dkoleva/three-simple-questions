package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.dao.UserProfile;
import com.three.simple.questions.backend.web.UserProfileDTO;

import java.util.List;

public interface ProfileService {

    List<UserProfileDTO> getProfiles();

    UserProfileDTO saveUserProfiles(UserProfileDTO userProfileDTO);

    UserProfile saveUserProfile(UserProfile userProfile);

    UserProfileDTO getProfileByIdentifier(String identifier) throws Exception;

    UserProfile getProfileByGuid(String guid);

    List<UserProfileDTO> getProfilesForUser();

    void saveMatchedUserProfile(String userGuid, String matchedUserGuid);
}
