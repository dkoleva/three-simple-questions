package com.three.simple.questions.backend.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileDAO extends MongoRepository<UserProfile, String> {
}
