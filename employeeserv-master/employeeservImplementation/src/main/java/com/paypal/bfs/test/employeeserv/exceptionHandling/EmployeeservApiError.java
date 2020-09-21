package com.paypal.bfs.test.employeeserv.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class EmployeeservApiError {

	@ExceptionHandler({ RuntimeException.class })

	public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
		return error(INTERNAL_SERVER_ERROR, e);

	}

	@ExceptionHandler({ EmployeeServNotFoundException.class })
	public ResponseEntity<String> handleNotFoundException(EmployeeServNotFoundException e) {
		return error(NOT_FOUND, e);

	}

	@ExceptionHandler({ EmployeeServServiceException.class })
	public ResponseEntity<String> handleDogsServiceException(EmployeeServServiceException e) {
		return error(INTERNAL_SERVER_ERROR, e);

	}

	private ResponseEntity<String> error(HttpStatus status, Exception e) {
		return ResponseEntity.status(status).body(e.getMessage());

	}

}
	