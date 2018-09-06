package com.three.simple.questions.backend.service.questions;

import com.three.simple.questions.backend.dao.questions.Answer;
import com.three.simple.questions.backend.dao.questions.Question;
import com.three.simple.questions.backend.web.questions.AnswerDTO;
import com.three.simple.questions.backend.web.questions.QuestionAndAnswerDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class QuestionFactory {

    Question create(QuestionAndAnswerDTO questionAndAnswerDTO) {
        return new Question(null,
                UUID.randomUUID().toString(),
                questionAndAnswerDTO.getQuestionDTO().getText(),
                getAnswers(questionAndAnswerDTO.getQuestionDTO().getAnswerDTO()));
    }

    private Set<Answer> getAnswers(Set<AnswerDTO> answers) {
        return answers.stream()
                .map(this::getAnswer)
                .collect(Collectors.toSet());
    }

    private Answer getAnswer(AnswerDTO answerDTO) {
        return new Answer(UUID.randomUUID().toString(),
                answerDTO.getText());
    }
}
