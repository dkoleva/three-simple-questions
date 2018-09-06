package com.three.simple.questions.backend.service.questions;

import com.three.simple.questions.backend.dao.questions.Question;
import com.three.simple.questions.backend.dao.questions.QuestionDAO;
import com.three.simple.questions.backend.web.questions.AnswerDTO;
import com.three.simple.questions.backend.web.questions.QuestionAndAnswerDTO;
import com.three.simple.questions.backend.web.questions.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return new QuestionAndAnswerDTO(questionAndAnswerDTO.getUserGuid(), getQuestionDTO(question));
    }

    private QuestionDTO getQuestionDTO(Question question) {
        return new QuestionDTO(question.getGuid(),
                question.getQuestion(),
                question.getAnswers()
                        .stream()
                        .map(answer -> new AnswerDTO(answer.getGuid(),
                            answer.getAnswer(),
                                null))
                        .collect(Collectors.toSet())
                );
    }
}
