package paypal.bfs.functionaltests.employeeserv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeAddress;
import com.paypal.bfs.test.employeeserv.h2.crud.H2JDBCUtils;
import static org.springframework.http.HttpMethod.GET;

public class EmployeeServApiTests {
	
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Mock
	private H2JDBCUtils h2JDBCUtils;
	
	@Mock
	private EmployeeResource employeeResource;
	
	
	@Test
	public void testCreateEmployee() {
	    String url = "http://localhost:8080/v1/bfs/employees";
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
	    HttpEntity<Employee> request = new HttpEntity<Employee>(employee);
	    
	    ResponseEntity<Employee> employeeResponse = restTemplate.postForEntity(url, request, Employee.class);
	    assertEquals(HttpStatus.OK, employeeResponse.getStatusCode());
	    assertEquals(100, employeeResponse.getBody().getId(), 0);
	    assertEquals("firstName", employeeResponse.getBody().getFirstName());
	    assertEquals("lastName", employeeResponse.getBody().getLastName());
	    assertEquals("10102010", employeeResponse.getBody().getDateOfBirth());
	    EmployeeAddress expectedEmployeeAddress = employee.getAddress();
	    assertNotNull(expectedEmployeeAddress);
	    assertEquals("line1", expectedEmployeeAddress.getLine1());
	    assertEquals("line2", expectedEmployeeAddress.getLine2());
	    assertEquals("city", expectedEmployeeAddress.getCity());
	    assertEquals("state", expectedEmployeeAddress.getState());
	    assertEquals("country", expectedEmployeeAddress.getCountry());
	    assertEquals("zip_code", expectedEmployeeAddress.getZip_code());
	}
	
	@Test
	public void testGetEmployee() {
	    String url = "http://localhost:8080/v1/bfs/employees/2";
	    ResponseEntity<Employee> employeeResponse = restTemplate.exchange(url, GET, HttpEntity.EMPTY, Employee.class);
	    assertEquals(HttpStatus.OK, employeeResponse.getStatusCode());
	    assertEquals("FirstTest", employeeResponse.getBody().getFirstName());
	}


}