package com.witsoftware.apioperation.utils;

import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.witsoftware.apioperation.model.Operation;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class Utils {

	public static String createID()	{
	    return UUID.randomUUID().toString();
	}
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String convertOperationToString(Operation operation) {
		try {
			log.info("Convert operation to JSON");
			return mapper.writeValueAsString(operation);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public static Message createMessage (Operation operation, String uuid) {
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setHeader("Unique-Identifier", uuid);
		return new Message(Utils.convertOperationToString(operation).toString().getBytes(), messageProperties);
	}
}
