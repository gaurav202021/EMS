package com.ems.handler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;

/**
 * 
 * @author  Dev
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 
	 * @param employeeRepository
	 */
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	/**
	 * get all emp
	 */
	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	/**
	 * get emp
	 */
	public Employee getEmployee(Long employeeId) {
		Optional<Employee> optEmp = employeeRepository.findById(employeeId);
		return optEmp.get();
	}

	/**
	 * save emp
	 */
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	/**
	 * emp update
	 */
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
}
