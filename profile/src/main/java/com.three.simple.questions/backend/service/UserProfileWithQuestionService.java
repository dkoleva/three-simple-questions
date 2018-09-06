package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.web.UserProfileWithQuestionsDTO;

import java.util.List;

public interface UserProfileWithQuestionService {

    List<UserProfileWithQuestionsDTO> getProfilesForUser(String guid);

    List<UserProfileWithQuestionsDTO> getProfiles();
}
