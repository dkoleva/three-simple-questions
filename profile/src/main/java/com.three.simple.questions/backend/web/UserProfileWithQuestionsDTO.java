package com.three.simple.questions.backend.web;

import com.three.simple.questions.backend.web.questions.QuestionDTO;

import java.util.List;

public class UserProfileWithQuestionsDTO {

    private final String guid;
    private final String name;
    private final String bio;
    private final String imageUrl;
    private final String email;
    private final List<QuestionDTO> questionDtoList;

    public UserProfileWithQuestionsDTO(String guid,
                                       String name,
                                       String bio,
                                       String imageUrl,
                                       String email,
                                       List<QuestionDTO> questionDtoList) {
        this.guid = guid;
        this.name = name;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.email = email;
        this.questionDtoList = questionDtoList;
    }

    public String getName() {
        return name;
    }

    public String getGuid() {
        return guid;
    }

    public String getBio() {
        return bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public List<QuestionDTO> getQuestionDtoList() {
        return questionDtoList;
    }
}
