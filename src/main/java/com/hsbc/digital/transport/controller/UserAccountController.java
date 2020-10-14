package com.hsbc.digital.transport.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsbc.digital.transport.errorhandler.DefaultExceptionHandler;
import com.hsbc.digital.transport.errorhandler.RecordNotFoundException;
import com.hsbc.digital.transport.model.Location;
import com.hsbc.digital.transport.model.Routes;
import com.hsbc.digital.transport.model.User;
import com.hsbc.digital.transport.model.UserDetailedInfo;
import com.hsbc.digital.transport.model.UserFullInfo;
import com.hsbc.digital.transport.repository.LocationRepository;
import com.hsbc.digital.transport.repository.RoutesRepository;
import com.hsbc.digital.transport.repository.UserDetailsRepository;
import com.hsbc.digital.transport.repository.UserRepository;

@RestController
@CrossOrigin
public class UserAccountController {

	@Autowired
	UserRepository userRepository;

	

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	RoutesRepository routesRepository;

	@Autowired
	DefaultExceptionHandler defaultExceptionHandler;

	@RequestMapping(path = "/employeeSignUp/{role}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public User addUser(@Valid @RequestBody User user, @PathVariable("role") String role) {

		user.setRole(role);
		return userRepository.save(user);

	}

	@RequestMapping(path = "/retrieveEmployees", method = RequestMethod.GET, produces = "application/json")
	public List<User> findUser() {

		return userRepository.findAll();

	}

	@RequestMapping(path = "/employeeLogin", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus

	public ResponseEntity<User> loginUser(@RequestParam String userName, @RequestParam String passWord) {
		if ((userRepository.getUserByUserNameAndPassword(userName, passWord).equals(null))) {
			throw new RecordNotFoundException("invalid username or password");

		} else {
			return new ResponseEntity<User>((userRepository.findByUserNameOrPassWord(userName, passWord)),
					HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/employeeLogout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String logout() {

		return "logged out successfully";

	}

	@RequestMapping(path = "/employeeRegister/{psid}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public UserDetailedInfo registerEmployee(@Valid @RequestBody UserDetailedInfo userDetailedInfo,
			@PathVariable("psid") String psid) {

		if ((userRepository.getUserByUserName(psid).equals(null))) {
			throw new RecordNotFoundException("invalid username");
		}
		userDetailedInfo.setPsid(psid);
		return userDetailsRepository.save(userDetailedInfo);
	}

	@RequestMapping(path = "/employeeSignUpInfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> retrieveEmployeeSignUpInfoUsingPSID(@RequestParam String userName) {

		return new ResponseEntity<User>(userRepository.getUserByUserName(userName), HttpStatus.OK);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(path = "/RegisteredEmployeeInfo/{peopleSoftId}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public ResponseEntity retrieveEmployeeFullInfoUsingPSID(@PathVariable("peopleSoftId") String peopleSoftId,
			UserDetailedInfo userDetailedInfo) {

		User user = userRepository.getUserByUserName(peopleSoftId);
		UserDetailedInfo userDetails = userDetailsRepository.getUserByPSID(peopleSoftId);
		return new ResponseEntity(new UserFullInfo(user, userDetails), HttpStatus.OK);

	}

	@RequestMapping(path = "/employeeDelete/{peopleSoftId}", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public void DeleteEmployeeFullInfoUsingPSID(@PathVariable("peopleSoftId") String peopleSoftId,
			UserDetailedInfo userDetailedInfo) {

		userDetailsRepository.deleteUserByPSID(peopleSoftId);
		userRepository.deleteUserByPSID(peopleSoftId);

	}

	@RequestMapping(path = "/employeeUpdate/{peopleSoftId}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public void updateEmployeeSignUpInfoUsingPSID(@Valid @RequestBody UserFullInfo userFullInfo,
			@PathVariable("peopleSoftId") String peopleSoftId) {
		User user = userFullInfo.getUser();
		UserDetailedInfo userDetailedInfo = userFullInfo.getUserDetailedInfo();
		userRepository.UpdateUserInfoByPSID(user.getPassword(), user.getPhoneNumber(), peopleSoftId);
		userDetailsRepository.UpdateUserDetailsByPSID(userDetailedInfo.getAddress(), userDetailedInfo.getDepartment(),
				userDetailedInfo.getDesignation(), userDetailedInfo.getEmergencyContactNumber(),
				userDetailedInfo.getExtensionNumber(), userDetailedInfo.getLineManager(), userDetailedInfo.getPsid());
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// location related//

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/locations/{locationName}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public ResponseEntity retrieveLocationsFullInfoUsingLocationName(
			@PathVariable(value = "locationName") String locationName) {

		return new ResponseEntity(locationRepository.getDetailsByLocationName(locationName), HttpStatus.OK);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/locations", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public ResponseEntity retrieveAllLocationsFullInfo() {

		return new ResponseEntity(locationRepository.findAll(), HttpStatus.OK);

	}

	@RequestMapping(path = "/addLocations", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public ResponseEntity<Location> postLocation(@Valid @RequestBody Location location) throws JsonProcessingException {

		ArrayList<String> buildings = new ArrayList<String>();
		buildings.add(location.getBuilding1());
		buildings.add(location.getBuilding2());
		buildings.add(location.getBuilding3());
		buildings.add(location.getBuilding4());

		location.setBuildings(buildings);
		return new ResponseEntity<Location>(locationRepository.save(location), HttpStatus.OK);

	}

	@RequestMapping(path = "/updateLocation/{locationName}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public void updateLocation(@Valid @RequestBody Location location, @PathVariable("locationName") String locationName)
			throws JsonProcessingException {
		locationRepository.UpdateUserInfoByPSID(location.getCost(), location.getComments(), location.getBuilding1(),
				location.getBuilding2(), location.getBuilding3(), location.getBuilding4(), locationName);

	}

	@RequestMapping(path = "/deleteLocation/{locationName}", method = RequestMethod.DELETE, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public void DeleteLocationUsingLocation(@PathVariable("locationName") String locationName) {

		locationRepository.deleteUserBylocationName(locationName);

	}

	///////////////////////////////////////////////
	@RequestMapping(path = "/addRoutes", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public ResponseEntity<Routes> postRoutes(@Valid @RequestBody Routes routes) throws JsonProcessingException {
		ArrayList<String> drop_locations = new ArrayList<String>();
		drop_locations.add(routes.getDropLocation1());
		drop_locations.add(routes.getDropLocation2());
		drop_locations.add(routes.getDropLocation3());
		drop_locations.add(routes.getDropLocation4());
		drop_locations.add(routes.getDropLocation5());
		drop_locations.add(routes.getDropLocation6());
		drop_locations.add(routes.getDropLocation7());
		drop_locations.add(routes.getDropLocation8());
		drop_locations.add(routes.getDropLocation9());
		drop_locations.add(routes.getDropLocation10());

		routes.setDropLocations(drop_locations);

		ArrayList<String> boarding_locations = new ArrayList<String>();
		boarding_locations.add(routes.getBoardingLocation1());
		boarding_locations.add(routes.getBoardingLocation2());
		boarding_locations.add(routes.getBoardingLocation3());
		boarding_locations.add(routes.getBoardingLocation4());
		boarding_locations.add(routes.getBoardingLocation5());
		boarding_locations.add(routes.getBoardingLocation6());
		boarding_locations.add(routes.getBoardingLocation7());
		boarding_locations.add(routes.getBoardingLocation8());
		boarding_locations.add(routes.getBoardingLocation9());
		boarding_locations.add(routes.getBoardingLocation10());
		routes.setBoradingLocations(boarding_locations);
		
		routes.setLocation(routes.getLocationName());
		routes.setCapacity(routes.getBusCapacity());
		routes.setUpdatedCapacity(routes.getBusCapacity());
		routes.setRouteNo(routes.getRouteNumber());
		return new ResponseEntity<Routes>(routesRepository.save(routes), HttpStatus.OK);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/routes/{locationName}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public ResponseEntity getRoutes(@PathVariable(value = "locationName") String locationName)
			throws JsonProcessingException {
		return new ResponseEntity(routesRepository.getRoutesByLocationName(locationName), HttpStatus.OK);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(path = "/routes/{locationName}/{routeNumber}", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public ResponseEntity getRoutes(@PathVariable(value = "locationName") String locationName,
			@PathVariable(value = "routeNumber") String routeNumber) throws JsonProcessingException {
		return new ResponseEntity(routesRepository.getDetailsByLocationNameAndRouteNumber(locationName, routeNumber),
				HttpStatus.OK);

	}

	@RequestMapping(path = "/busRegistration/{location}/{routeNo}", method = RequestMethod.POST, consumes = {
				MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	 @ResponseStatus(HttpStatus.OK)
	public String submitRegistration(@Valid @RequestBody Routes routes,@PathVariable(value = "location") String location,@PathVariable(value = "routeNo") String routeNo) {
	
	  String capacity= routesRepository.getDetailsByLocationNameAndRouteNumber(location, routeNo).getUpdatedCapacity();
	  int updateCap=Integer.valueOf(capacity)-1;
      routes.setUpdatedCapacity(String.valueOf(updateCap));
      
      routesRepository.updateAvailableCapacityByLocationAndRoute(routes.getUpdatedCapacity(), location, routeNo);
	 
	   return routes.getUpdatedCapacity();
	}
         
}