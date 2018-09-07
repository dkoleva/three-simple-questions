package com.three.simple.questions.backend.dao;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

public class UserProfile {

    @Id
    private String id;
    private String guid;
    private String name;
    private String bio;
    private String imageUrl;
    private String email;
    private List<QuestionAndAnswer> questionAndAnswer;
    private List<String> matchedUserGuid;

    public UserProfile(String id,
                       String guid,
                       String name,
                       String bio,
                       String imageUrl,
                       String email,
                       List<QuestionAndAnswer> questionAndAnswer,
                       List<String> matchedUserGuid) {
        this.id = id;
        this.guid = guid;
        this.name = name;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.email = email;
        this.questionAndAnswer = questionAndAnswer;
        this.matchedUserGuid = matchedUserGuid;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public List<QuestionAndAnswer> getQuestionAndAnswer() {
        return questionAndAnswer;
    }

    public void setQuestionAndAnswer(List<QuestionAndAnswer> questionAndAnswer) {
        this.questionAndAnswer = questionAndAnswer;
    }

    public List<String> getMatchedUserGuids() {
        return matchedUserGuid;
    }

    public void setMatchedUserGuid(List<String> matchedUserGuid) {
        this.matchedUserGuid = matchedUserGuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(bio, that.bio) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(email, that.email) &&
                Objects.equals(questionAndAnswer, that.questionAndAnswer) &&
                Objects.equals(matchedUserGuid, that.matchedUserGuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, guid, name, bio, imageUrl, email, questionAndAnswer, matchedUserGuid);
    }
}
