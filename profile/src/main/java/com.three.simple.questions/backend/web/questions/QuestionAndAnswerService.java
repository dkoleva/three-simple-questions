package com.three.simple.questions.backend.web.questions;

import java.util.List;

public interface QuestionAndAnswerService {

    QuestionAndAnswerDTO addQuestionsAndAnswers(QuestionAndAnswerDTO questionAndAnswerDTO);

    List<QuestionDTO> getQuestions();
}
