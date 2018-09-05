package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.dao.ProfileDAO;
import com.three.simple.questions.backend.web.UserProfileDTO;
import com.three.simple.questions.backend.dao.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService{

    private final ProfileDAO profileDAO;

    @Autowired
    public ProfileServiceImpl(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    public List<UserProfileDTO> getProfiles() {
        return profileDAO.findAll()
                .stream()
                .map(this::getUserProfileDTO)
                .collect(Collectors.toList());
   }



    @Override
    public UserProfileDTO saveUserProfiles(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = new UserProfile(null, UUID.randomUUID().toString(), userProfileDTO.getBio(), userProfileDTO.getImageUrl(), userProfileDTO.getEmail());
        profileDAO.save(userProfile);
        return getUserProfileDTO(userProfile);
    }

    @Override
    public UserProfileDTO getProfileByIdentifier(String identifier) throws Exception {
        return this.profileDAO.findProfileByEmail(identifier)
                .or(() -> this.profileDAO.findProfileByGuid(identifier))
                .map(this::getUserProfileDTO)
                .orElseThrow(() -> new ProfileNotFoundException(identifier + "Not found"));
    }

    private UserProfileDTO getUserProfileDTO(UserProfile userProfile) {
        return new UserProfileDTO(userProfile.getGuid(),
                userProfile.getBio(),
                userProfile.getImageUrl(),
                userProfile.getEmail());
    }
}
