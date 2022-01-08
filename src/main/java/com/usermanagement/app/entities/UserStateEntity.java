package com.usermanagement.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="STATE_DETAILS")
public class UserStateEntity {

	@Id
	@Column(name="STATE_ID")
	private Integer stateId;
	@Column(name= "STATE_NAME")
	private String stateName;
	@Column(name= "COUNTRY_ID")
	private Integer countryId;
}
