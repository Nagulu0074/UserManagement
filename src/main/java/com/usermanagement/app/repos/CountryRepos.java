package com.usermanagement.app.repos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.app.entities.UserCountryEntity;
@Repository
public interface CountryRepos extends JpaRepository<UserCountryEntity, Serializable> {

}
