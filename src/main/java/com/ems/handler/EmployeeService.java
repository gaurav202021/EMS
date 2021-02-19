package com.ems.handler;

import java.util.List;

import com.ems.model.Employee;
/**
 * 
 * @author  Dev
 *
 */
public interface EmployeeService {
	
	 public List<Employee> retrieveEmployees();
	  
	 public Employee getEmployee(Long employeeId);
	  
	 public Employee saveEmployee(Employee employee);
	  	  
	 public Employee updateEmployee(Employee employee);

}
