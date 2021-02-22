package com.ems.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ems.exception.EmsException;
import com.ems.handler.EmsBusinessHandler;
import com.ems.model.EmployeeRequest;
import com.ems.model.WsResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "EMS System", description = "ems")
public class EMSController {
	@Autowired
	private EmsBusinessHandler employeeHandler;
	Logger LOGGER = LoggerFactory.getLogger(EMSController.class);

	/**
	 * Method is used to update employeee
	 * @param id
	 * @param status
	 * @return
	 * @throws EmsException
	 */
	@PutMapping("/api/v1/ems/{id}")
	@ApiOperation(value = "API to update employee status")
	public ResponseEntity<WsResponse> updateEmployeeStatus(@PathVariable(name = "id") long id,
			@RequestParam(name = "status") String status) throws EmsException {
		LOGGER.info("Update  Employee !!!");
		WsResponse response = employeeHandler.updateUser(id, status);
		return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
	}

	/**
	 * Method is used to add 
	 * @param employee
	 * @return
	 * @throws EmsException
	 */
	@ApiOperation(value = "API to add employee")
	@PostMapping(path = "/api/v1/ems", produces = "application/json")
	public ResponseEntity<WsResponse> saveEmployee(@Valid @RequestBody EmployeeRequest employee) throws EmsException {
		LOGGER.info("Add Employee !!!");
		WsResponse wsResponse = employeeHandler.AddEmployee(employee);
		return new ResponseEntity<WsResponse>(wsResponse, HttpStatus.CREATED);

	}

	/**
	 * 
	 * @return
	 * @throws EmsException
	 */
	@GetMapping(path = "/api/v1/ems")
	@ApiOperation(value = "API to get all employee")
	public ResponseEntity<WsResponse> getAllEmployee() throws EmsException {
		LOGGER.info("Get All Employee !!!");
		WsResponse wsResponse = employeeHandler.getAllEmployee();
		return new ResponseEntity<WsResponse>(wsResponse, HttpStatus.OK);

	}

}
