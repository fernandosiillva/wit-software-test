package com.witsoftware.apioperation.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witsoftware.apioperation.model.Operation;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Utils {

	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String convertOperationToString(Operation operation) {
		try {
			log.info("Convert operation to JSON");
			return mapper.writeValueAsString(operation);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
