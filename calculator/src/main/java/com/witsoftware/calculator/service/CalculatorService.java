package com.witsoftware.calculator.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.witsoftware.calculator.model.Operation;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CalculatorService {

	public BigDecimal typeOperation(Operation operation) {
		log.info("Calculate");
		return operation.getOperation().calculate(operation.getNumberA(), operation.getNumberB());
	}

}
