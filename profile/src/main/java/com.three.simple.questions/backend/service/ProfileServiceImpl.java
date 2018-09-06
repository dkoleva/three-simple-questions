package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.dao.ProfileDAO;
import com.three.simple.questions.backend.dao.UserProfile;
import com.three.simple.questions.backend.web.UserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService{

    private final ProfileDAO profileDAO;

    @Autowired
    public ProfileServiceImpl(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    public List<UserProfile> getProfiles() {
        return profileDAO.findAll();
   }

    @Override
    public UserProfileDTO saveUserProfiles(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = new UserProfile(null, UUID.randomUUID().toString(), userProfileDTO.getBio(), userProfileDTO.getImageUrl(), userProfileDTO.getEmail(), Collections.emptyList());
        profileDAO.save(userProfile);
        return getUserProfileDTO(userProfile);
    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        return profileDAO.save(userProfile);
    }

    @Override
    public UserProfileDTO getProfileByIdentifier(String identifier) throws Exception {
        return this.profileDAO.findProfileByEmail(identifier)
                .or(() -> this.profileDAO.findProfileByGuid(identifier))
                .map(this::getUserProfileDTO)
                .orElseThrow(() -> new ProfileNotFoundException(identifier + "Not found"));
    }

    @Override
    public UserProfile getProfileByGuid(String guid) {
        return profileDAO.findProfileByGuid(guid)
                .orElseThrow(() -> new ProfileNotFoundException(guid + "Not found"));
    }

    @Override
    public List<UserProfile> getProfilesForUser(String guid) {
        return profileDAO.findProfileByGuidNotIn(List.of(guid));

    }

    private UserProfileDTO getUserProfileDTO(UserProfile userProfile) {
        return new UserProfileDTO(userProfile.getGuid(),
                userProfile.getBio(),
                userProfile.getImageUrl(),
                userProfile.getEmail());
    }
}
