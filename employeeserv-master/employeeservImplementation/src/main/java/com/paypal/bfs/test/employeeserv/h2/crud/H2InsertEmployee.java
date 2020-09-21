package com.paypal.bfs.test.employeeserv.h2.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exceptionHandling.EmployeeServNotFoundException;

public class H2InsertEmployee {

	private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO Employee"
			+ "  (id, first_name, last_name, date_of_birth, line1,line2,city,state,country,zip_code) VALUES "
			+ " (?, ?, ?, ?, ?,?,?,?,?,?);";

	public void insertRecord(Employee employee) throws SQLException {
		Connection connection = H2JDBCUtils.getConnection();
		try {			
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getDateOfBirth());
			preparedStatement.setString(5, employee.getAddress().getLine1());
			preparedStatement.setString(6, employee.getAddress().getLine2());
			preparedStatement.setString(7, employee.getAddress().getCity());
			preparedStatement.setString(8, employee.getAddress().getState());
			preparedStatement.setString(9, employee.getAddress().getCountry());
			preparedStatement.setString(10, employee.getAddress().getZip_code());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new EmployeeServNotFoundException(e.getMessage());
		} finally {
			connection.close();
		}
	}
}
