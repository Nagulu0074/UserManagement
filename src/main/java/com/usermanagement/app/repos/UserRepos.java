package com.usermanagement.app.repos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.app.entities.UserEntity;

@Repository
public interface UserRepos extends JpaRepository<UserEntity, Serializable> {

	public boolean findByuserEmailId(String email);

}
