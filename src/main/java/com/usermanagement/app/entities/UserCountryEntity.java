package com.usermanagement.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="COUNTRY_DETAILS")
public class UserCountryEntity {
	
	@Id
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	@Column(name="COUNTRY_NAME")
	private String countryName;
}
