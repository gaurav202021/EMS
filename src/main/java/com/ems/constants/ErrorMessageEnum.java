package com.ems.constants;


/**
 * @author Dev
 *
 * Error codes and messages
 */
public enum ErrorMessageEnum {

    APP001("Employye registartion failed"),
	APP002("Missing required fields"),
	APP003("Record not found"),
	APP004("Invalid User status"),;
	private String value;

	ErrorMessageEnum(String error) {
		this.value = error;
	}

	public String value() {
		return value;
	}
}
