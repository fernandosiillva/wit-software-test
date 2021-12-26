package com.witsoftware.apioperation.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.witsoftware.apioperation.enums.OperationEnum;
import com.witsoftware.apioperation.model.Operation;
import com.witsoftware.apioperation.model.Result;
import com.witsoftware.apioperation.service.OperationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@AllArgsConstructor
@Log4j2
@Api("Api-operation to calculate")
public class OperationController {

	private OperationService operationService;

	
	@GetMapping(value = "/sum", consumes = "application/json", produces="application/json")
	@ApiOperation("Sum operation")
	@ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
	public ResponseEntity<Result> sum(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
		log.info("GET /sum");
		return ResponseEntity.ok(operationService.sender(Operation.builder().numberA(a).numberB(b).operation(OperationEnum.SUM).build()));
	}
	
	@GetMapping(value = "/subtraction", consumes = "application/json", produces="application/json")
	@ApiOperation("Subtraction operation")
	@ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
	public ResponseEntity<Result> subtraction(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
		log.info("GET /subtraction");
		return ResponseEntity.ok(operationService.sender(Operation.builder().numberA(a).numberB(b).operation(OperationEnum.SUBTRACTION).build()));
	}
	
	@GetMapping(value = "/multiplication", consumes = "application/json", produces="application/json")
	@ApiOperation("Multiplication operation")
	@ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
	public ResponseEntity<Result> multiplication(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
		log.info("GET /multiplication");
		return ResponseEntity.ok(operationService.sender(Operation.builder().numberA(a).numberB(b).operation(OperationEnum.MULTIPLICATION).build()));
	}
	
	@GetMapping(value = "/division", consumes = "application/json", produces="application/json")
	@ApiOperation("Division operation")
	@ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
	public ResponseEntity<Result> division(@RequestParam BigDecimal a, @RequestParam BigDecimal b) {
		log.info("GET /division");
		return ResponseEntity.ok(operationService.sender(Operation.builder().numberA(a).numberB(b).operation(OperationEnum.DIVISION).build()));
	}

}
