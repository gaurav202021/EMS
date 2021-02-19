package com.ems.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ems.constants.EmsStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author dev
 *
 */

@Getter
@Setter
@JsonFormat()
public class EmployeeRequest {

	@Min(6)
	@JsonFormat()
	private Integer zip;
	@JsonFormat()
	private String job_title;

	@NotEmpty
	@JsonFormat()
	private String name;
	@JsonFormat()
	private Integer salary;
	@JsonFormat()
	private String department;
	@JsonFormat()
	private Integer age;
	@NotEmpty
	@JsonFormat()
	private String city;
	@NotEmpty
	@JsonFormat()
	private String state;
	@NotEmpty
	@JsonFormat()
	private String company_name;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(dataType = "java.sql.Date")
	private Date birthdate;

	@NotNull
	@JsonFormat()
	@NotBlank(message = "Please enter valid phone number")
	private String phoneNumber;

	private EmsStatusEnum status = EmsStatusEnum.ADDED;
}
