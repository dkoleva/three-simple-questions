package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.dao.UserProfile;
import com.three.simple.questions.backend.web.UserProfileDTO;

import java.util.List;

public interface ProfileService {

    List<UserProfile> getProfiles();

    UserProfileDTO saveUserProfiles(UserProfileDTO userProfileDTO);

    UserProfile saveUserProfile(UserProfile userProfile);

    UserProfileDTO getProfileByIdentifier(String identifier) throws Exception;

    UserProfile getProfileByGuid(String guid);

    List<UserProfile> getProfilesForUser(String guid);

    void saveMatchedUserProfile(String userGuid, String matchedUserGuid);
}
