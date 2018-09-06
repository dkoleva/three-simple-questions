package com.three.simple.questions.backend.web.questions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDTO {

    private final String guid;
    private final String text;
    private final Set<AnswerDTO> answers;

    public QuestionDTO(@JsonProperty("guid") String guid,
                       @JsonProperty("text") String text,
                       @JsonProperty("answer") Set<AnswerDTO> answerDTO) {
        this.guid = guid;
        this.text = text;
        this.answers = answerDTO;
    }

    public String getGuid() {
        return guid;
    }

    public String getText() {
        return text;
    }

    public Set<AnswerDTO> getAnswerDTO() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return Objects.equals(guid, that.guid) &&
                Objects.equals(text, that.text) &&
                Objects.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guid, text, answers);
    }
}
