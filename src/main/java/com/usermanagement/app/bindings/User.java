package com.usermanagement.app.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {

	private Integer userId;
	private String userFName;
	private String userLastName;
	private Long userContactNumber;
	private String userEmailId;
	private String gender;
	private Integer stateId;
	private Integer cityId;
	private Integer countryId;
	private LocalDate DOB;

	private String pwd;
	private String acctStatus;
	private LocalDate CREATEDDATE;
	private LocalDate UPDATEDDATE;
}
