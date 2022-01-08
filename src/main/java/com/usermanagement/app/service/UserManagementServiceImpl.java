package com.usermanagement.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.app.bindings.User;
import com.usermanagement.app.entities.UserCityEntity;
import com.usermanagement.app.entities.UserCountryEntity;
import com.usermanagement.app.entities.UserEntity;
import com.usermanagement.app.entities.UserStateEntity;
import com.usermanagement.app.repos.CityRepos;
import com.usermanagement.app.repos.CountryRepos;
import com.usermanagement.app.repos.StateRepos;
import com.usermanagement.app.repos.UserRepos;
import com.usermanagement.app.utils.EmailUtils;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserRepos userRepo;

	@Autowired
	private CountryRepos countryRepo;

	@Autowired
	private StateRepos stateRepo;

	@Autowired
	private CityRepos cityRepo;

	@Autowired
	private EmailUtils emailutils;

	@Override
	public boolean uniqueEmail(String email) {

		boolean userEntity = userRepo.findByuserEmailId(email);

		if (userEntity) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<Integer, String> getCountries() {
		List<UserCountryEntity> findAll = countryRepo.findAll();

		Map<Integer, String> countryMap = new HashMap<>();

		for (UserCountryEntity entity : findAll) {
			countryMap.put(entity.getCountryId(), entity.getCountryName());

		}
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer CountryId) {
		List<UserStateEntity> stateList = stateRepo.findAll();

		Map<Integer, String> stateMap = new HashMap<>();
		for (UserStateEntity userstate : stateList) {
			stateMap.put(userstate.getStateId(), userstate.getStateName());
		}
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer StateId) {
		List<UserCityEntity> citiesList = cityRepo.findBystateId(StateId);

		Map<Integer, String> cityMap = new HashMap<>();

		for (UserCityEntity city : citiesList) {
			cityMap.put(city.getCityId(), city.getCityName());
		}

		return cityMap;
	}

	@Override
	public boolean registerUser(User user) {

		user.setPwd(generateTempPwd());
		user.setAcctStatus("LOCKED");

		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity save = userRepo.save(entity);

		if (save.getUserId() != null) {
			return sendRegEmail(user);
		}
		return false;
	}

	private String generateTempPwd() {
		String tempPwd = null;
		int leftLimit = 48;// numeral'0'

		int rightLimit = 122;// letter 'z'
		int targetStringLength = 6;
		Random random = new Random();

		tempPwd = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(targetStringLength)

				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return tempPwd;

	}

	private boolean sendRegEmail(User user) {

		// boolean emailSent = false;
		String Subject = "REGISTRATION-SUCCESSFULL";
		String Body = mailBody(user);
		String userEmailId = user.getUserEmailId();
		boolean emailSent = emailutils.sendEmail(Subject, Body, userEmailId);

		return emailSent;
	}

	private String mailBody(User user) {
		// File file=new File("Template.txt");
		String mailbody = "";
		try {

			File file = new File("Template.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {

				String readLine = br.readLine();
				readLine = readLine.replace("{FNAME}", user.getUserFName());
				readLine = readLine.replace("{TEMP-PWD}", user.getPwd());
				readLine = readLine.replace("{FNAME}", user.getUserEmailId());
				mailbody = readLine;
			}
			br.close();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mailbody;
		
		

	}

}
