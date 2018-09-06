package com.three.simple.questions.backend.web.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerDTO {

    private final String guid;
    private final String text;
    private final Boolean correct;

    @JsonCreator
    public AnswerDTO(@JsonProperty("guid") String guid,
                     @JsonProperty("text") String text,
                     @JsonProperty("correct") Boolean correct) {
        this.guid = guid;
        this.text = text;
        this.correct = correct;
    }

    public String getGuid() {
        return guid;
    }

    public String getText() {
        return text;
    }

    public Boolean isCorrect() {
        return correct;
    }
}
