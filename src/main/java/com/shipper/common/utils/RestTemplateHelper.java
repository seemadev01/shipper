package com.shipper.common.utils;

import java.io.IOException;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RestTemplateHelper {

	private static final Logger LOGGER = Logger.getLogger(RestTemplateHelper.class);

	private RestTemplate restTemplate;

	private ObjectMapper objectMapper;

	private static final String NOT_DATA_FOUND_LOG_FORMAT = "No data found {}";

	private Supplier<ClientHttpRequestFactory> requestFactorySupplier = () -> new BufferingClientHttpRequestFactory(
			new SimpleClientHttpRequestFactory());

	@Autowired
	public RestTemplateHelper(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
		restTemplateBuilder.requestFactory(requestFactorySupplier);
		this.restTemplate = restTemplateBuilder.build();
		this.objectMapper = objectMapper;
	}

	public <T, R> T postForEntity(Class<T> clazz, String url, R body, Object... uriVariables) {
		HttpEntity<R> request = new HttpEntity<>(body);
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class, uriVariables);
		JavaType javaType = objectMapper.getTypeFactory().constructType(clazz);
		return readValue(response, javaType);
	}

	private <T> T readValue(ResponseEntity<String> response, JavaType javaType) {
		T result = null;
		if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
			try {
				result = objectMapper.readValue(response.getBody(), javaType);
			} catch (IOException e) {
				LOGGER.info(e.getMessage());
			}
		} else {
			LOGGER.info(NOT_DATA_FOUND_LOG_FORMAT, response.getStatusCode());
		}
		return result;
	}

}
