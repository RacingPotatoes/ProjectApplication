package com.poc.logger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.poc.logger.entity.LoggerEntity;

@Repository
public interface LoggerRepository extends MongoRepository<LoggerEntity, String>{

}
