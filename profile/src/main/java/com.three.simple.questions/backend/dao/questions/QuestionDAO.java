package com.three.simple.questions.backend.dao.questions;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionDAO extends MongoRepository<Question, String> {

    Optional<Question> findByGuid(String guid);

    List<Question> findByGuidIn(List<String> guids);
}
