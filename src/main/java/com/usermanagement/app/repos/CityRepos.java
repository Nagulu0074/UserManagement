package com.usermanagement.app.repos;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.app.entities.UserCityEntity;
@Repository
public interface CityRepos extends JpaRepository<UserCityEntity,Serializable> {

	List<UserCityEntity> findBystateId(Integer stateId);

}
