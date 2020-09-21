package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exceptionHandling.EmployeeServNotFoundException;
import com.paypal.bfs.test.employeeserv.exceptionHandling.EmployeeServServiceException;
import com.paypal.bfs.test.employeeserv.h2.crud.H2GetEmployee;
import com.paypal.bfs.test.employeeserv.h2.crud.H2InsertEmployee;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Override
	public ResponseEntity<Employee> employeeGetById(String id) throws SQLException {

		Employee employee = new Employee();
		try {
			H2GetEmployee h2getEmployee = new H2GetEmployee();
			employee = h2getEmployee.getEmployeeRecord(id);

		} catch (EmployeeServServiceException ex) {
			throw new EmployeeServServiceException("Unable to get response for GET employeeserv API : " + ex.getMessage());
		} catch (EmployeeServNotFoundException ex) {
			throw new EmployeeServNotFoundException("Unable to get response for GET employeeserv API : " + ex.getMessage());
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws SQLException {
		try {
			H2InsertEmployee h2InsertEmployee = new H2InsertEmployee();
			h2InsertEmployee.insertRecord(employee);

		} catch (EmployeeServServiceException ex) {
			throw new EmployeeServServiceException("Unable to create employee using POST employeeserv API : " + ex.getMessage());
		} catch (EmployeeServNotFoundException ex) {
			throw new EmployeeServNotFoundException("Unable to create employee using POST employeeserv API : " + ex.getMessage());
		} catch(SQLException ex) {
			throw new EmployeeServNotFoundException(ex.getMessage());
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
