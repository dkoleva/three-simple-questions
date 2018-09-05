package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.dao.ProfileDAO;
import com.three.simple.questions.backend.web.UserModel;
import com.three.simple.questions.backend.dao.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService{

    private final ProfileDAO profileDAO;

    @Autowired
    public ProfileServiceImpl(ProfileDAO profileDAO) {
        this.profileDAO = profileDAO;
    }

    public List<UserModel> getProfiles() {
        profileDAO.save(new UserProfile("123", "guid1", "some bio", "some image", "some email"));


        List<UserProfile> userProfiles = profileDAO.findAll();

        return userProfiles
                .stream()
                .map(this::getUserModel)
                .collect(Collectors.toList());
        //return new UserProfile("123", "guid1", "some bio", "some image", "some email");
    }

    private UserModel getUserModel(UserProfile userProfile) {
        return new UserModel(userProfile.getGuid(),
                userProfile.getBio(),
                userProfile.getImageUrl(),
                userProfile.getEmail());
    }
}
