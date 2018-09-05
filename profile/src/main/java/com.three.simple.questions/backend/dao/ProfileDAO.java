package com.three.simple.questions.backend.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileDAO extends MongoRepository<UserProfile, String> {

    Optional<UserProfile> findProfileByEmail(String email);

    Optional<UserProfile> findProfileByGuid(String guid);



}
