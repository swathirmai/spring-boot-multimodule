package employeeservImplementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeAddress;
import com.paypal.bfs.test.employeeserv.h2.crud.H2GetEmployee;
import com.paypal.bfs.test.employeeserv.h2.crud.H2InsertEmployee;
import com.paypal.bfs.test.employeeserv.h2.crud.H2JDBCUtils;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;

@RunWith(MockitoJUnitRunner.class)
public class employeeServApiTests {
	
	@Mock
	private H2JDBCUtils h2JDBCUtils;
	
	@InjectMocks
	private H2GetEmployee h2GetEmployee;
	
	@Mock
	private H2InsertEmployee h2InsertEmployee;
	
	@Mock
	private EmployeeResourceImpl employeeResourceImpl;
	
	@Test
	public void testGetEmployeeRecord() throws SQLException {
		Employee actualEmp = h2GetEmployee.getEmployeeRecord("100");
		assertNotNull(actualEmp);
		assertEquals("firstName", actualEmp.getFirstName());
	}
	
	@Test
	public void testInsertEmployeeRecord() throws SQLException {
		Employee employee = new Employee();
		EmployeeAddress employeeAddress = new EmployeeAddress();
		employee.setId(100);
		employee.setFirstName("firstName");
		employee.setLastName("lastName");
		employee.setDateOfBirth("10102010");
		employeeAddress.setLine1("line1");
		employeeAddress.setLine2("line2");
		employeeAddress.setCity("city");
		employeeAddress.setState("state");
		employeeAddress.setCountry("country");
		employeeAddress.setZip_code("zip_code");
		employee.setAddress(employeeAddress);
	    h2InsertEmployee.insertRecord(employee);
	}
	

}