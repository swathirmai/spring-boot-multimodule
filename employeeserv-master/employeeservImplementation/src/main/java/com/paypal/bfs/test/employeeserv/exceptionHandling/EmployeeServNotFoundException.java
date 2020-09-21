package com.paypal.bfs.test.employeeserv.exceptionHandling;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeServNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeServNotFoundException(String message) {
        super(message);

    }


}
