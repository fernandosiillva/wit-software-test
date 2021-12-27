package com.witsoftware.apioperation.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.witsoftware.apioperation.config.RabbitMQConfigSender;
import com.witsoftware.apioperation.model.Operation;
import com.witsoftware.apioperation.model.Result;
import com.witsoftware.apioperation.utils.Utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OperationService {

	private RabbitMQConfigSender configSender;
	
	public Result sender(Operation operation, String uuid) {
		return new Result(new BigDecimal(configSender.sendAndReturn(Utils.createMessage(operation, uuid)).toString()));
	}
}
