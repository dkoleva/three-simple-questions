package com.three.simple.questions.backend.web.questions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

    private final String guid;
    private final String text;

    public QuestionDTO(@JsonProperty("guid") String guid,
                       @JsonProperty("text") String text) {
        this.guid = guid;
        this.text = text;
    }

    public String getGuid() {
        return guid;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return Objects.equals(guid, that.guid) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guid, text);
    }
}
