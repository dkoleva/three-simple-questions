package com.three.simple.questions.backend.service.questions;

import com.three.simple.questions.backend.web.questions.QuestionAndAnswerDTO;
import com.three.simple.questions.backend.web.questions.QuestionDTO;
import com.three.simple.questions.backend.web.questions.AnswerDTO;

import java.util.List;

public interface QuestionService {
    QuestionAndAnswerDTO addQuestion(QuestionAndAnswerDTO questionAndAnswerDTO);

    List<QuestionDTO> getQuestions();
/*
    QuestionDTO addQuestion(QuestionDTO questionDTO);

    QuestionDTO deleteQuestion(QuestionDTO questionDTO);

    List<AnswerDTO> getAnswers();

    AnswerDTO addAnswer(AnswerDTO answerDTO);

    AnswerDTO deleteAnswer(AnswerDTO answerDTO);*/
}
