package com.three.simple.questions.backend.web.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.three.simple.questions.backend.dao.questions.Answer;

import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerDTO {

    private final String guid;
    private final String text;

    @JsonCreator
    public AnswerDTO(@JsonProperty("guid") String guid,
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
}
