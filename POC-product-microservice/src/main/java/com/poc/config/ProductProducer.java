package com.poc.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProductProducer {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServer;

	public Map<String, Object> producerConfiguration() {
		Map<String, Object> property = new HashMap<>();
		property.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		property.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		property.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return property;
	}

	@Bean
	public ProducerFactory<String, String> factory() {
		return new DefaultKafkaProducerFactory<>(producerConfiguration());
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> factory) {
		return new KafkaTemplate<>(factory);
	}
}
