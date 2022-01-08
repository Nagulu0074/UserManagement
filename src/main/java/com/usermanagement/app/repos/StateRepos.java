package com.usermanagement.app.repos;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.app.entities.UserStateEntity;

@Repository
public interface StateRepos extends JpaRepository<UserStateEntity,Serializable> {
	public List<UserStateEntity> findBycountryId(Integer countryId);

}
