package com.ems.handler;

import com.ems.model.*;
import com.ems.exception.EmsException;

public interface EmsBusinessHandler {

	WsResponse AddEmployee(EmployeeRequest employee) throws EmsException;
	WsResponse getAllEmployee() throws EmsException;
	WsResponse updateUser(long id, String status)throws EmsException;
	
}
