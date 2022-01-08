package com.usermanagement.app.rest;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.usermanagement.app.bindings.User;
import com.usermanagement.app.service.UserManagementService;

@Controller
public class RegistrationRestController {

	private UserManagementService regService;

	@GetMapping("/checkmail/{email}")
	public String checkMail(@PathVariable String email) {
		
		boolean uniqueEmail = regService.uniqueEmail(email);
		if(uniqueEmail) {
			return "unique";
		}else
		
		return "duplicate";

	}
	@GetMapping("/countries")
	public Map<Integer,String> getCountries(){
		
		return regService.getCountries();
	}
	@GetMapping("/states/{countryId}")
	public Map<Integer,String> getStates(@PathVariable Integer countryId){
		return regService.getStates(countryId);
		
	}
	@GetMapping("/cities/{statesId}")
	public Map<Integer,String> getCities(@PathVariable Integer stateId){
		return regService.getCities(stateId);		
	}
		
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		boolean registerUser = regService.registerUser(user);
		if (registerUser) {

			return "SUCCESS";
		} else {
			return "failed";
		}

	}
}
