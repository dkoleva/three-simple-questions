package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.web.UserModel;

import java.util.List;

public interface ProfileService {

    List<UserModel> getProfiles();
}
