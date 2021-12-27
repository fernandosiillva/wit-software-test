package com.witsoftware.calculator.consumer;

import java.math.BigDecimal;

import org.slf4j.MDC;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.witsoftware.calculator.config.RabbitMQConfigReceiver;
import com.witsoftware.calculator.service.CalculatorService;
import com.witsoftware.calculator.utils.Utils;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class Consumer {

	CalculatorService calculatorService;
	
	@RabbitListener(queues = RabbitMQConfigReceiver.queueName)
	public BigDecimal consumer (Message message) {
		MDC.put("uuid", message.getMessageProperties().getHeader("Unique-Identifier").toString());
		log.info("Receiving message");
		try {
			return calculatorService.typeOperation(Utils.convertStringToOperation(new String(message.getBody(), "UTF-8")));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
