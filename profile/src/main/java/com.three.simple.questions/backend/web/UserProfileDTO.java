package com.three.simple.questions.backend.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileDTO {

    private final String guid;
    private final String name;
    private final String bio;
    private final String imageUrl;
    private final String email;

    @JsonCreator
    public UserProfileDTO(@JsonProperty("guid") String guid,
                          @JsonProperty("name") String name,
                          @JsonProperty("bio") String bio,
                          @JsonProperty("imageUrl") String imageUrl,
                          @JsonProperty("email") String email) {
        this.guid = guid;
        this.name = name;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileDTO that = (UserProfileDTO) o;
        return Objects.equals(guid, that.guid) &&
                Objects.equals(name, that.name) &&
                Objects.equals(bio, that.bio) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guid, name, bio, imageUrl, email);
    }
}
