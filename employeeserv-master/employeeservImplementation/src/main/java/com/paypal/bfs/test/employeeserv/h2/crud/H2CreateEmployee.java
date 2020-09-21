package com.paypal.bfs.test.employeeserv.h2.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2CreateEmployee {

	private static final String createTableSQL = "create table Employee (\r\n" + "  id  int(3) primary key,\r\n"
			+ "  first_name varchar(255),\r\n" + "  last_name varchar(255),\r\n" 
			+ "  date_of_birth varchar(20),\r\n" 
			+ "  line1 varchar(20),\r\n" 
			+ "  line2 varchar(20),\r\n" 
			+ "  city varchar(20),\r\n" 
			+ "  state varchar(20),\r\n"  
			+ "  country varchar(20),\r\n"
			+ "  zip_code varchar(20)\r\n" + "  );";

	public static void main(String[] argv) throws SQLException {
		H2CreateEmployee createEmployee = new H2CreateEmployee();
		createEmployee.createTable();
	}

	public void createTable() throws SQLException {

		Connection connection = H2JDBCUtils.getConnection();
		try {			
			Statement statement = connection.createStatement();
			statement.execute(createTableSQL);

		} catch (SQLException e) {
			H2JDBCUtils.printSQLException(e);
		} finally {
			connection.close();
			
		}
	}
}