package com.witsoftware.calculator.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum OperationEnum {
	
	SUM{
		@Override
		public BigDecimal calculate(BigDecimal numberA, BigDecimal numberB) {
			log.info(numberA + " SUM " + numberB);
			return numberA.add(numberB);
		}
	},
	DIVISION {
		@Override
		public BigDecimal calculate(BigDecimal numberA, BigDecimal numberB) {
			log.info(numberA + " DIVISION " + numberB);
			return numberA.divide(numberB, 2, RoundingMode.HALF_UP);
		}
	},
	MULTIPLICATION {
		@Override
		public BigDecimal calculate(BigDecimal numberA, BigDecimal numberB) {
			log.info(numberA + " MULTIPLICATION " + numberB);
			return numberA.multiply(numberB);
		}
	},
	SUBTRACTION {
		@Override
		public BigDecimal calculate(BigDecimal numberA, BigDecimal numberB) {
			log.info(numberA + " SUBTRACTION " + numberB);
			return numberA.subtract(numberB);
		}
	};

	public abstract BigDecimal calculate(BigDecimal numberA, BigDecimal numberB);
}
