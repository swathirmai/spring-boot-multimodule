package com.paypal.bfs.test.employeeserv.h2.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeAddress;


public class H2GetEmployee {

	private static final String QUERY = "select id, first_name, last_name, date_of_birth, line1,line2,city,state,country,zip_code from Employee where id =?";

	public Employee getEmployeeRecord(String id) throws SQLException {
		Employee employee = new Employee();
		EmployeeAddress employeeAddress = new EmployeeAddress();
		Connection connection = H2JDBCUtils.getConnection();
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
			preparedStatement.setInt(1, Integer.valueOf(id));
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id_val = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String date_of_birth = rs.getString("date_of_birth");
				String line1 = rs.getString("line1");
				String line2 = rs.getString("line2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String country = rs.getString("country");
				String zip_code = rs.getString("zip_code");
				employee.setId(id_val);
				employee.setFirstName(first_name);
				employee.setLastName(last_name);
				employee.setDateOfBirth(date_of_birth);
				employeeAddress.setLine1(line1);
				employeeAddress.setLine2(line2);
				employeeAddress.setCity(city);
				employeeAddress.setState(state);
				employeeAddress.setCountry(country);
				employeeAddress.setZip_code(zip_code);
				employee.setAddress(employeeAddress);
			
			}
		} catch (SQLException e) {
			H2JDBCUtils.printSQLException(e);
		} finally {
			connection.close();
		}
		return employee;

	}
}
