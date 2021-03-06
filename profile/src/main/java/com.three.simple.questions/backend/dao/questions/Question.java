package com.three.simple.questions.backend.dao.questions;

import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.Set;

public class Question {

    @Id
    private String id;
    private String guid;
    private String text;
    private Set<Answer> answers;

    public Question(String id,
                    String guid,
                    String text,
                    Set<Answer> answers) {
        this.id = id;
        this.guid = guid;
        this.text = text;
        this.answers = answers;
    }

    public String getId() {
        return id;

    }

    public String getGuid() {
        return guid;
    }

    public String getQuestion() {
        return text;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(guid, question.guid) &&
                Objects.equals(text, question.text) &&
                Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guid, text, answers);
    }
}
