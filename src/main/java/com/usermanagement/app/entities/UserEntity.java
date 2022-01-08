package com.usermanagement.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


@Entity
@Table(name= "USER_DETAILS")
@Data
public class UserEntity {

	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="USER_FNAME")
	private String userFName;
	
	@Column(name="USER_LNAME")
	private String userLastName;
	@Column(name="USER_CONTACTNUMBER")
	private Integer userContactNumber;
	@Column(name="USER_EMAILID",unique=true)
	private String userEmailId;
	@Column(name="USER_GENDER")
	private String gender;
	@Column(name="USER_STATEID")
	private Integer stateId;
	@Column(name="USER_CITYId")
	private Integer cityId;
	@Column(name="USER_COUNTRYID")
	private Integer countryId;
	@Column(name="USER_DOB")
	private LocalDate DOB;
	@Column(name="USER_PWD")
	private String pwd;
	@Column(name="USER_ACCTSTATUS")	
	private String acctStatus;
	@CreationTimestamp
	private LocalDate CREATEDDATE;
	@UpdateTimestamp
	private LocalDate UPDATEDDATE;
}
