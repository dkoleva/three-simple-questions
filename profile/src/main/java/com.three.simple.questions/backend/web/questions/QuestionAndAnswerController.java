package com.three.simple.questions.backend.web.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionAndAnswerController {

    private final QuestionAndAnswerService questionAndAnswerService;

    @Autowired
    public QuestionAndAnswerController(QuestionAndAnswerService questionService) {
        this.questionAndAnswerService = questionService;
    }

    @PutMapping("/questions")
    public QuestionAndAnswerDTO addQuestion(@RequestBody QuestionAndAnswerDTO questionAndAnswerDTO) {
        return questionAndAnswerService.addQuestionsAndAnswers(questionAndAnswerDTO);
    }

   @GetMapping("/questions")
    public List<QuestionDTO> getQuestions() {
        return questionAndAnswerService.getQuestions();
    }
/*
    public QuestionDTO addQuestion(QuestionDTO questionDTO) {
        return questionAndAnswerService.addQuestion(questionDTO);
    }

    public QuestionDTO deleteQuestion(QuestionDTO questionDTO) {
        return questionAndAnswerService.deleteQuestion(questionDTO);
    }

    @GetMapping("/answers")
    public List<AnswerDTO> getAnswers() {
        return questionAndAnswerService.getAnswers();
    }

    public AnswerDTO addAnswer(AnswerDTO answerDTO) {
        return questionAndAnswerService.addAnswer(answerDTO);
    }

    public AnswerDTO deleteAnswer(AnswerDTO answerDTO) {
        return questionAndAnswerService.deleteAnswer(answerDTO);
    }*/
}
