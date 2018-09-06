package com.three.simple.questions.backend.web;

public class UserProfileWithQuestionsDTO {

    private final String guid;
    private final String bio;
    private final String imageUrl;
    private final String email;

    public UserProfileWithQuestionsDTO(String guid, String bio, String imageUrl, String email) {
        this.guid = guid;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.email = email;
    }
}
