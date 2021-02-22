package com.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ems.constants.EmsStatusEnum;
import com.ems.controller.EMSController;
import com.ems.exception.EmsException;
import com.ems.handler.EmsBusinessHandler;
import com.ems.model.Employee;
import com.ems.model.EmployeeRequest;
import com.ems.model.WsResponse;

@ExtendWith(MockitoExtension.class)
class EmsApplicationTest {


	@InjectMocks
	EMSController employeeController;

	@Mock
	private EmsBusinessHandler employeeHandler;



	@Test
	public void testAddEmployee() throws EmsException {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(employeeHandler.AddEmployee(any(EmployeeRequest.class))).thenReturn(new WsResponse());

		@Valid
		EmployeeRequest employee = new EmployeeRequest();

		ResponseEntity<WsResponse> responseEntity = employeeController.saveEmployee(employee);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

	@Test
	public void testFindAll() throws EmsException {
		
		// given
		Employee employee1 = new Employee(1L, "test", 18, "Mumbai", "MH", 858585, "dev", "Infosys", null,
				null, null, "1234567890", null);
		Employee employee2 = new Employee(2L, "test2", 22, "Delhi", "DL", 262625, "head", "Infosys", null, null,
				null, "1234567890", null);
		List<Employee> employees = Arrays.asList(employee1, employee2);
		WsResponse emp = new WsResponse();
		emp.setData(employees);
		when(employeeHandler.getAllEmployee()).thenReturn(emp);

		// when
		ResponseEntity<WsResponse> responseEntity = employeeController.getAllEmployee();

		// then
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	
	}
	
	@Test
	public void testUpdateEmployee() throws EmsException {
		
		// given
		Employee employee1 = new Employee(1L, "test", 18, "Mumbai", "MH", 858585, "dev", "Infosys", null,
				null, null, "1234567890", EmsStatusEnum.ACTIVE );
		WsResponse emp = new WsResponse();
		emp.setData(employee1);
		when(employeeHandler.getAllEmployee()).thenReturn(emp);

		// when
		ResponseEntity<WsResponse> responseEntity = employeeController.updateEmployeeStatus(1L, "ACTIVE");

		// then
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	
	}

}
