package com.witsoftware.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.witsoftware.calculator.enums.OperationEnum;
import com.witsoftware.calculator.model.Operation;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class CalculatorServiceTest {

	private CalculatorService service;

	@BeforeEach
	public void inicializa() {
		this.service = new CalculatorService();
	}
	
	@Test
	@DisplayName("Sum operation validation")
	void sumOperationTest() {
		BigDecimal result = service.typeOperation(Operation.builder().numberA(new BigDecimal(1)).numberB(new BigDecimal(2))
				.operation(OperationEnum.SUM).build());
		
		assertEquals(new BigDecimal(3), result);
	}
	
	@Test
	@DisplayName("Sum operation subtraction")
	void subtractionOperationTest() {
		BigDecimal result = service.typeOperation(Operation.builder().numberA(new BigDecimal(3)).numberB(new BigDecimal(2))
				.operation(OperationEnum.SUBTRACTION).build());
		
		assertEquals(new BigDecimal(1), result);
	}
	
	@Test
	@DisplayName("Sum operation multiplication")
	void multiplicationOperationTest() {
		BigDecimal result = service.typeOperation(Operation.builder().numberA(new BigDecimal(3)).numberB(new BigDecimal(2))
				.operation(OperationEnum.MULTIPLICATION).build());
		
		assertEquals(new BigDecimal(6), result);
	}
	
	@Test
	@DisplayName("Sum operation division")
	void divisionOperationTest() {
		BigDecimal result = service.typeOperation(Operation.builder().numberA(new BigDecimal(3)).numberB(new BigDecimal(3))
				.operation(OperationEnum.DIVISION).build());
		
		assertEquals(new BigDecimal(1).setScale(2, RoundingMode.HALF_UP), result);
	}

}
