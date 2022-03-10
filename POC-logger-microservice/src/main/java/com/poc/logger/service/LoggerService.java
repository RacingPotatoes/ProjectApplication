package com.poc.logger.service;

import org.springframework.stereotype.Service;

@Service
public interface LoggerService {
	public void consumeTopics(String data);
}
