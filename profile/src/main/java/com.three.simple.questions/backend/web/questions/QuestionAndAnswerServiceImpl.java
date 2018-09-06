package com.three.simple.questions.backend.web.questions;

import com.three.simple.questions.backend.dao.QuestionAndAnswer;
import com.three.simple.questions.backend.dao.UserProfile;
import com.three.simple.questions.backend.service.ProfileService;
import com.three.simple.questions.backend.service.questions.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAndAnswerServiceImpl implements QuestionAndAnswerService {

    private final QuestionService questionService;
    private final ProfileService profileService;

    @Autowired
    public QuestionAndAnswerServiceImpl(QuestionService questionService,
                                        ProfileService profileService) {
        this.questionService = questionService;
        this.profileService = profileService;
    }

    @Override
    public QuestionAndAnswerDTO addQuestionsAndAnswers(QuestionAndAnswerDTO questionAndAnswerDTO) {
        QuestionAndAnswerDTO updatedQuestionAndAnswerDTO = questionService.addQuestion(questionAndAnswerDTO);
        UserProfile profile = profileService.getProfileByGuid(updatedQuestionAndAnswerDTO.getUserGuid());
        List<QuestionAndAnswer> questionAndAnswer = profile.getQuestionAndAnswer();
        questionAndAnswer.add(getQuestionAndAnswer(updatedQuestionAndAnswerDTO));
        profile.setQuestionAndAnswer(questionAndAnswer);
        profileService.saveUserProfile(profile);
        return updatedQuestionAndAnswerDTO;
    }

    @Override
    public List<QuestionDTO> getQuestions( ) {
        return questionService.getQuestions();
    }

    private QuestionAndAnswer getQuestionAndAnswer(QuestionAndAnswerDTO updatedQuestionAndAnswerDTO) {
        return new QuestionAndAnswer(updatedQuestionAndAnswerDTO.getQuestionDTO().getGuid(),
                getAnswerDTOStream(updatedQuestionAndAnswerDTO));
    }

    private String getAnswerDTOStream(QuestionAndAnswerDTO questionAndAnswerDTO) {
        return questionAndAnswerDTO.getQuestionDTO()
                .getAnswerDTO()
                .stream()
                .filter(AnswerDTO::isCorrect)
                .findFirst()
                .get()
                .getGuid();
    }
}
