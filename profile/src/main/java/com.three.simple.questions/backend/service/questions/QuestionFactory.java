package com.three.simple.questions.backend.service.questions;

import com.three.simple.questions.backend.dao.questions.Question;
import com.three.simple.questions.backend.web.questions.QuestionAndAnswerDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class QuestionFactory {

    public Question create(QuestionAndAnswerDTO questionAndAnswerDTO) {
        return new Question(null, UUID.randomUUID().toString(), questionAndAnswerDTO.getQuestionDTO().getText());
    }
}
