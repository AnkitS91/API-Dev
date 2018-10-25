package com.justClick.api.gateway;

import java.util.Map;

import org.springframework.http.HttpHeaders;

public interface ExternalGateway<T> {

	public Object post(String url, T payload);

	public Object post(String url, T payload, Class<?> classOfType);

	public Object post(String url, T payload, HttpHeaders headers,Class<?> classOfType);
	
	public void put(String url, T payload);

	public Object get(String url);

	public Object get(String url,HttpHeaders headers);

	public Map<String, Object> post(String url, T payload, HttpHeaders headers, Class<?> classOfType, String key);

	public Map<String, Object> parseResponse(Object response, String key);
}
