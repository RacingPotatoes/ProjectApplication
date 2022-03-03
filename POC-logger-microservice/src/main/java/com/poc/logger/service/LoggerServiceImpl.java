package com.poc.logger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.poc.logger.entity.LoggerEntity;
import com.poc.logger.repository.LoggerRepository;

@Service
public class LoggerServiceImpl implements LoggerService {
	@Autowired
	LoggerRepository loggerRepository;

	@Override
	@KafkaListener(topics = "Products_Logs", groupId = "pm")
	public void consumeTopics(String data) {
		System.out.println("New Log : " + data);
		LoggerEntity entity = new LoggerEntity();
		entity.setLogData(data);
		loggerRepository.save(entity);
	}

}
