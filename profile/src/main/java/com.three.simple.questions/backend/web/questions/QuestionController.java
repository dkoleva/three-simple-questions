package com.three.simple.questions.backend.web.questions;

import com.three.simple.questions.backend.service.questions.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    //TODO: 1 - What mappings to use? 2 - Fix line 18 below

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PutMapping("/questions")
    public QuestionAndAnswerDTO addQuestion(@RequestBody QuestionAndAnswerDTO questionAndAnswerDTO) {
        return questionService.addQuestion(questionAndAnswerDTO);
    }


/*    @GetMapping("/questions")
    public List<QuestionDTO> getQuestions() {
        return questionService.getQuestions();
    }

    public QuestionDTO addQuestion(QuestionDTO questionDTO) {
        return questionService.addQuestion(questionDTO);
    }

    public QuestionDTO deleteQuestion(QuestionDTO questionDTO) {
        return questionService.deleteQuestion(questionDTO);
    }

    @GetMapping("/answers")
    public List<AnswerDTO> getAnswers() {
        return questionService.getAnswers();
    }

    public AnswerDTO addAnswer(AnswerDTO answerDTO) {
        return questionService.addAnswer(answerDTO);
    }

    public AnswerDTO deleteAnswer(AnswerDTO answerDTO) {
        return questionService.deleteAnswer(answerDTO);
    }*/
}
