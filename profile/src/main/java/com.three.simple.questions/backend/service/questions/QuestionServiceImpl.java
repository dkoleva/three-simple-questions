package com.three.simple.questions.backend.service.questions;

import com.three.simple.questions.backend.dao.questions.Answer;
import com.three.simple.questions.backend.dao.questions.Question;
import com.three.simple.questions.backend.dao.questions.QuestionDAO;
import com.three.simple.questions.backend.web.questions.AnswerDTO;
import com.three.simple.questions.backend.web.questions.QuestionAndAnswerDTO;
import com.three.simple.questions.backend.web.questions.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionFactory questionFactory;
    private final QuestionDAO questionDAO;

    @Autowired
    public QuestionServiceImpl(QuestionFactory questionFactory,
                               QuestionDAO questionDAO) {
        this.questionFactory = questionFactory;
        this.questionDAO = questionDAO;
    }

    @Override
    public QuestionAndAnswerDTO addQuestion(QuestionAndAnswerDTO questionAndAnswerDTO) {
        Question question = questionFactory.create(questionAndAnswerDTO);
        questionDAO.save(question);

        Answer correctAnswer = getCorrectAnswer(questionAndAnswerDTO, question);

        Set<AnswerDTO> answerDTOS = getAnswers(question, correctAnswer);

        return new QuestionAndAnswerDTO(questionAndAnswerDTO.getUserGuid(), getQuestionDTO(question, answerDTOS));
    }

    private Set<AnswerDTO> getAnswers(Question question, Answer correctAnswer) {
        return question.getAnswers().stream()
                .map(answer -> {
                    var isCorrect = false;
                    if (answer.getAnswer().equalsIgnoreCase(correctAnswer.getAnswer())) {
                        isCorrect = true;
                    }

                    return new AnswerDTO(answer.getGuid(), answer.getAnswer(), isCorrect);
                })
                .collect(Collectors.toSet());
    }

    private Answer getCorrectAnswer(QuestionAndAnswerDTO questionAndAnswerDTO, Question question) {
        AnswerDTO first = questionAndAnswerDTO.getQuestionDTO().getAnswerDTO().stream()
                .filter(AnswerDTO::isCorrect)
                .findFirst()
                .get();

        return question.getAnswers().stream()
                .filter(savedAnswer -> savedAnswer.getAnswer().equalsIgnoreCase(first.getText()))
                .findFirst()
                .get();
    }

    private QuestionDTO getQuestionDTO(Question question, Set<AnswerDTO> answerDTOS) {
        return new QuestionDTO(question.getGuid(),
                question.getQuestion(),
                answerDTOS);
    }
}
