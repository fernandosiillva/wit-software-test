package com.witsoftware.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.witsoftware.calculator.enums.OperationEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Operation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigDecimal numberA;
	private BigDecimal numberB;
	private OperationEnum operation;
}
