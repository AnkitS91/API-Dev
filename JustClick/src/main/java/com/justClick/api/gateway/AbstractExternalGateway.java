package com.justClick.api.gateway;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class AbstractExternalGateway<T> implements ExternalGateway<T> {

	@Autowired
	protected RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public Object post(String url, T payload) {
		JsonNode responeJsonNode;
		HttpEntity<T> httpEntity;
		httpEntity = new HttpEntity<>(payload);
		responeJsonNode = restTemplate.postForObject(url, httpEntity, JsonNode.class);
		return parseResponse(responeJsonNode);
	}

	@Override
	public void put(String url, T payload) {
		HttpEntity<T> httpEntity;
		httpEntity = new HttpEntity<>(payload);
		restTemplate.put(url, httpEntity);
	}

	@Override
	public Object get(String url) {
		return restTemplate.getForObject(url, JsonNode.class);
	}

	public abstract Object parseResponse(Object response);

	public abstract HttpHeaders createHeaders(Object... body);

	@Override
	public Object get(String url, HttpHeaders headers) {
		return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(headers), Object.class).getBody();
	}

	@Override
	public Object post(String url, T payload, Class<?> classOfType) {
		HttpEntity<T> httpEntity;
		httpEntity = new HttpEntity<>(payload);
		return parseResponse(restTemplate.postForObject(url, httpEntity, classOfType));
	}

	@Override
	public Object post(String url, T payload, HttpHeaders headers, Class<?> classOfType) {
		HttpEntity<T> httpEntity;
		httpEntity = new HttpEntity<>(payload, headers);
		return parseResponse(restTemplate.postForObject(url, httpEntity, classOfType));
	}
	
	@Override
	public Map<String, Object> post(String url, T payload, HttpHeaders headers, Class<?> classOfType, String key) {
		HttpEntity<T> httpEntity;
		httpEntity = new HttpEntity<>(payload, headers);
		return parseResponse(restTemplate.postForObject(url, httpEntity, classOfType), key);
	}
	/**
	 * This method parses the callback response received
	 **/
	@Override
	public Map<String, Object> parseResponse(Object response, String key) {
		return (Map<String, Object>) parseResponse(response, null);
	}
}
