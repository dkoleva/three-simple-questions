package com.three.simple.questions.backend.web.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionAndAnswerDTO {

    private final String userGuid;
    private final QuestionDTO questionDTO;

    @JsonCreator
    public QuestionAndAnswerDTO(@JsonProperty("userGuid") String userGuid,
                                @JsonProperty("questionDTO") QuestionDTO questionDTO) {
        this.userGuid = userGuid;
        this.questionDTO = questionDTO;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public QuestionDTO getQuestionDTO() {
        return questionDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionAndAnswerDTO that = (QuestionAndAnswerDTO) o;
        return Objects.equals(userGuid, that.userGuid) &&
                Objects.equals(questionDTO, that.questionDTO);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userGuid, questionDTO);
    }
}
