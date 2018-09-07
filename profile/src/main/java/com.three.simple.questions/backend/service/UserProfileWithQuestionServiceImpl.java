package com.three.simple.questions.backend.service;

import com.three.simple.questions.backend.dao.QuestionAndAnswer;
import com.three.simple.questions.backend.dao.UserProfile;
import com.three.simple.questions.backend.dao.questions.Question;
import com.three.simple.questions.backend.service.questions.QuestionService;
import com.three.simple.questions.backend.web.UserProfileWithQuestionsDTO;
import com.three.simple.questions.backend.web.questions.AnswerDTO;
import com.three.simple.questions.backend.web.questions.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserProfileWithQuestionServiceImpl implements UserProfileWithQuestionService {

    private final ProfileService profileService;
    private final QuestionService questionService;

    @Autowired
    public UserProfileWithQuestionServiceImpl(ProfileService profileService,
                                              QuestionService questionService) {
        this.profileService = profileService;
        this.questionService = questionService;
    }

    @Override
    public List<UserProfileWithQuestionsDTO> getProfiles() {
        List<UserProfile> profilesForUser = profileService.getProfiles();

        List<String> questionGuids = new ArrayList<>();

        for (UserProfile userProfile : profilesForUser) {
            for (QuestionAndAnswer questionAndAnswer : userProfile.getQuestionAndAnswer()) {
                questionGuids.add(questionAndAnswer.getQuestionGuid());
            }
        }

        List<Question> questions = questionService.getQuestionsByGuids(questionGuids);

        return profilesForUser
                .stream()
                .map(userProfile -> getUserProfileWithQuestionsDTO(userProfile, questions))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserProfileWithQuestionsDTO> getProfilesForUser(String guid) {
        List<UserProfile> profilesForUser = profileService.getProfilesForUser(guid);

        List<String> questionGuids = new ArrayList<>();

        for (UserProfile userProfile : profilesForUser) {
            for (QuestionAndAnswer questionAndAnswer : userProfile.getQuestionAndAnswer()) {
                questionGuids.add(questionAndAnswer.getQuestionGuid());
            }
        }

        List<Question> questions = questionService.getQuestionsByGuids(questionGuids);

        return profilesForUser
                .stream()
                .map(userProfile -> getUserProfileWithQuestionsDTO(userProfile, questions))
                .collect(Collectors.toList());
    }

    private UserProfileWithQuestionsDTO getUserProfileWithQuestionsDTO(UserProfile userProfile, List<Question> questions) {
        return new UserProfileWithQuestionsDTO(
                userProfile.getGuid(),
                userProfile.getName(), userProfile.getBio(),
                userProfile.getImageUrl(),
                userProfile.getEmail(),
                questions.isEmpty() ? Collections.emptyList() : getQuestionDTOS(userProfile, questions));
    }

    private List<QuestionDTO> getQuestionDTOS(UserProfile userProfile, List<Question> questions) {
        List<QuestionDTO> questionDTOS = new ArrayList<>();

        for (QuestionAndAnswer questionAndAnswer : userProfile.getQuestionAndAnswer()) {
            questionDTOS.addAll(questions.stream()
                    .filter(question -> question.getGuid().equals(questionAndAnswer.getQuestionGuid()))
                    .map(question -> new QuestionDTO(question.getGuid(),
                            question.getQuestion(),
                            getAnswers(question, questionAndAnswer.getAnswerGuid())))
                    .collect(Collectors.toList()));
        }

        return questionDTOS;
    }

    private Set<AnswerDTO> getAnswers(Question question, String correctAnswerGuid) {
        return question.getAnswers()
        .stream()
        .map(answer -> new AnswerDTO(answer.getGuid(),
                answer.getAnswer(),
                answer.getGuid().equals(correctAnswerGuid)))
        .collect(Collectors.toSet());
    }
}
