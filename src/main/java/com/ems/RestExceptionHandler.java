package com.ems;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ems.model.*;
import com.ems.constants.*;
import com.ems.exception.EmsException;

/**
 * 
 * @author  Dev
 *
 */
@ControllerAdvice
public class RestExceptionHandler {
	/**
	 * 
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(EmsException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody WsResponse handleResourceNotFound(final EmsException exception,
			final HttpServletRequest request) {
		final WsResponse error = new WsResponse();
		error.setErrorMessage(exception.getErrorMessge());
		error.setErrorCode(exception.getErrorCode());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		return error;
	}

	/**
	 * 
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody WsResponse handleException(final Exception exception, final HttpServletRequest request) {

		final WsResponse error = new WsResponse();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return error;
	}

	/**
	 * used to get error msg when request related validation fire
	 * @param exp
	 * @return
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody WsResponse handleValidationExceptions(final MethodArgumentNotValidException exp) {

		final Map<String, String> errors = new HashMap<>();

		exp.getBindingResult().getAllErrors().forEach((obj) -> {
			errors.put(((FieldError) obj).getField(), obj.getDefaultMessage());
		});
		final WsResponse error = new WsResponse();
		error.setErrorInfo(errors);
		error.setErrorMessage(ErrorMessageEnum.APP002.value());
		error.setErrorCode(ErrorMessageEnum.APP002.name());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		return error;
	}
}