package com.three.simple.questions.backend.dao.questions;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Answer {

    private String guid;
    private String answer;

    public Answer(String guid, String answer) {
        this.guid = guid;
        this.answer = answer;
    }

    public String getGuid() {
        return guid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return Objects.equals(guid, answer1.guid) &&
                Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guid, answer);
    }
}
