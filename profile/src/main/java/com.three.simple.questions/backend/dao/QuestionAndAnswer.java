package com.three.simple.questions.backend.dao;

public class QuestionAndAnswer {

    private String questionGuid;
    private String answerGuid;

    public QuestionAndAnswer(String questionGuid, String answerGuid) {
        this.questionGuid = questionGuid;
        this.answerGuid = answerGuid;
    }

    public String getQuestionGuid() {
        return questionGuid;
    }

    public void setQuestionGuid(String questionGuid) {
        this.questionGuid = questionGuid;
    }

    public String getAnswerGuid() {
        return answerGuid;
    }

    public void setAnswerGuid(String answerGuid) {
        this.answerGuid = answerGuid;
    }
}
