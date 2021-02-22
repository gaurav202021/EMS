package com.ems.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ems.constants.EmsStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEE")
@Setter
@Getter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonFormat
	private Long id;

	@Column(name = "EMPLOYEE_NAME")
	@JsonFormat
	private String name;

	@Column(name = "AGE")
	@JsonFormat
	private Integer age;

	@Column(name = "CITY")
	@JsonFormat
	private String city;

	@Column(name = "STATE")
	@JsonFormat
	private String state;

	@Column(name = "ZIP")
	@JsonFormat
	private Integer zip;

	@Column(name = "JOB_TITLE")
	@JsonFormat
	private String job_title;

	@Column(name = "company_name")
	@JsonFormat
	private String company_name;

	@Column(name = "birthdate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;

	@Column(name = "EMPLOYEE_SALARY")
	@JsonFormat
	private Integer salary;

	@Column(name = "DEPARTMENT")
	@JsonFormat
	private String department;

	@Column(name = "phoneNumber")
	@JsonFormat
	private String phoneNumber;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "STATUS")
	@JsonFormat
	private EmsStatusEnum status;

	public Employee()
	{
		
	}

	public Employee(Long id, String name, Integer age, String city, String state, Integer zip, String job_title,
			String company_name, Date birthdate, Integer salary, String department, String phoneNumber,
			EmsStatusEnum status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.job_title = job_title;
		this.company_name = company_name;
		this.birthdate = birthdate;
		this.salary = salary;
		this.department = department;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}



	public void setstatus(EmsStatusEnum status) {
		this.status = status;
	}

}