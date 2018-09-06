package com.three.simple.questions.backend.service.questions;

import com.three.simple.questions.backend.dao.questions.Answer;
import com.three.simple.questions.backend.dao.questions.Question;
import com.three.simple.questions.backend.web.questions.QuestionAndAnswerDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class QuestionFactory {

    Question create(QuestionAndAnswerDTO questionAndAnswerDTO) {
        return new Question(null,
                UUID.randomUUID().toString(),
                questionAndAnswerDTO.getQuestionDTO().getText(),
                getAnswer(questionAndAnswerDTO));
    }

    private Answer getAnswer(QuestionAndAnswerDTO questionAndAnswerDTO) {
        return new Answer(UUID.randomUUID().toString(), questionAndAnswerDTO.getQuestionDTO().getAnswerDTO().getText());
    }
}
