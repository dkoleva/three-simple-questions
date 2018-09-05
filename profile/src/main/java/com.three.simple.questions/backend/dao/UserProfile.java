package com.three.simple.questions.backend.dao;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class UserProfile {

    @Id
    private String id;
    private String guid;
    private String bio;
    private String imageUrl;
    private String email;

    public UserProfile(String id,
                       String guid,
                       String bio,
                       String imageUrl,
                       String email) {
        this.id = id;
        this.guid = guid;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(guid, that.guid) &&
                Objects.equals(bio, that.bio) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, guid, bio, imageUrl, email);
    }
}
