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
    private final Set<Answer> answers;

    @JsonCreator
    public AnswerDTO(@JsonProperty("guid") String guid,
                     @JsonProperty("answers") Set<Answer> answers) {
        this.guid = guid;
        this.answers = answers;
    }

    public String getGuid() {
        return guid;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerDTO answerDTO = (AnswerDTO) o;
        return Objects.equals(guid, answerDTO.guid) &&
                Objects.equals(answers, answerDTO.answers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guid, answers);
    }
}
