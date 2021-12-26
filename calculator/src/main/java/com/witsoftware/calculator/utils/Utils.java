package com.witsoftware.calculator.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witsoftware.calculator.model.Operation;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Utils {

	private static ObjectMapper mapper = new ObjectMapper();
	
	public static Operation convertStringToOperation(String operation) {
		try {
			log.info("Convert message to Operation");
			return mapper.readValue(operation, Operation.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
