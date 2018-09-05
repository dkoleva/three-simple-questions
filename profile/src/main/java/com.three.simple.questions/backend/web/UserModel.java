package com.three.simple.questions.backend.web;

import java.util.Objects;

public class UserModel {

    private String guid;
    private String bio;
    private String imageUrl;
    private String email;

    public UserModel(String guid, String bio, String imageUrl, String email) {
        this.guid = guid;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.email = email;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(guid, userModel.guid) &&
                Objects.equals(bio, userModel.bio) &&
                Objects.equals(imageUrl, userModel.imageUrl) &&
                Objects.equals(email, userModel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, bio, imageUrl, email);
    }
}
