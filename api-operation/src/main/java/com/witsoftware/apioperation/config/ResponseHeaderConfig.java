package com.witsoftware.apioperation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class ResponseHeaderConfig {
	
	private static HttpHeaders responseHeaders = new HttpHeaders();
	
	public static HttpHeaders responseHeaders(String uniqueIdentifier) {
		responseHeaders.set("Unique-Identifier", uniqueIdentifier);
		return responseHeaders;

	}
	
}
