package com.usermanagement.app.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.usermanagement.app.bindings.User;

@Service
public interface UserManagementService {

	public boolean uniqueEmail(String email);

	public Map<Integer, String> getCountries();

	public Map<Integer, String> getStates(Integer CountryId);

	public Map<Integer, String> getCities(Integer StateId);

	public boolean registerUser(User user);

}
