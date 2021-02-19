package com.ems.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ems.constants.EmsStatusEnum;
import com.ems.constants.ErrorMessageEnum;
import com.ems.constants.ResponseMessage;
import com.ems.exception.EmsException;
import com.ems.model.Employee;
import com.ems.model.EmployeeRequest;
import com.ems.model.WsResponse;
/**
 * 
 * @author dev
 *
 */
@Component
public class EmsBusinessHandlerImpl implements EmsBusinessHandler {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModelMapperUtil modelMapperUtil;

	/**
	 * Method is used to create new employee
	 */
	@Override
	public WsResponse AddEmployee(EmployeeRequest employees) throws EmsException {
		final WsResponse response = new WsResponse();
		

		// employee here is a prepopulated employee instance
		Employee empsave = modelMapperUtil.map(employees, Employee.class);
		
//		empsave.setStatus(EmployeeStatusEnum.ADDED);
		empsave = employeeService.saveEmployee(empsave);
		if (empsave == null) {
			throw new EmsException(ErrorMessageEnum.APP001.name(), ErrorMessageEnum.APP001.value());
		}
		response.setMessage(ResponseMessage.SUCCESS);
		response.setStatus((empsave == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
		response.setData(empsave);
		return response;

	}

	/**
	 * Method is used to get all employee
	 */
	@Override
	public WsResponse getAllEmployee() throws EmsException {
		final WsResponse response = new WsResponse();
		final List<Employee> employee = employeeService.retrieveEmployees();
		response.setData(employee);
		response.setStatus(HttpStatus.OK.value());
		response.setMessage(ResponseMessage.SUCCESS);
		return response;
	}

	/**
	 * Method is used to update employee status
	 */
	@Override
	public WsResponse updateUser(long id, String status) throws EmsException {
		final WsResponse response = new WsResponse();
		Employee findEmp = employeeService.getEmployee(id);
		if (findEmp == null) {
			throw new EmsException(ErrorMessageEnum.APP003.name(), ErrorMessageEnum.APP003.value());
		}
		if (!EmsStatusEnum.isType(status)) {
			throw new EmsException(ErrorMessageEnum.APP004.name(), ErrorMessageEnum.APP004.value());
		}
		findEmp.setstatus(EmsStatusEnum.getType(status));
		findEmp = employeeService.updateEmployee(findEmp);
		response.setStatus((findEmp == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
		response.setData(findEmp);
		response.setMessage(ResponseMessage.UPDATED);
		return response;
	}

}
