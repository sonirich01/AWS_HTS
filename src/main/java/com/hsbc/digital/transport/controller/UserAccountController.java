package com.hsbc.digital.transport.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.digital.transport.errorhandler.DefaultExceptionHandler;
import com.hsbc.digital.transport.errorhandler.RecordNotFoundException;
import com.hsbc.digital.transport.model.User;
import com.hsbc.digital.transport.model.UserDetailedInfo;
import com.hsbc.digital.transport.model.UserFullInfo;
import com.hsbc.digital.transport.repository.RoleRepository;
import com.hsbc.digital.transport.repository.UserDetailsRepository;
import com.hsbc.digital.transport.repository.UserRepository;

@RestController
@CrossOrigin
public class UserAccountController {

	@Autowired
	UserRepository userRepository;
	

	@Autowired
	UserDetailsRepository userDetailsRepository;
	
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
        if((userRepository.getUserByUserNameAndPassword(userName,passWord).equals(null))) {
          throw new RecordNotFoundException("invalid username or password");
		
        }
        else {
        	return new ResponseEntity<User>((userRepository.findByUserNameOrPassWord(userName, passWord)),HttpStatus.OK);
        }
	}
	
	@RequestMapping(value = "/employeeLogout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String logout() {

		return "logged out successfully";

	}
	
	@RequestMapping(path = "/employeeRegister/{psid}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public UserDetailedInfo registerEmployee(@Valid @RequestBody UserDetailedInfo userDetailedInfo,@PathVariable("psid") String psid) {
     
		 if((userRepository.getUserByUserName(psid).equals(null))) {
			 throw new RecordNotFoundException("invalid username"); 
		 }
		 userDetailedInfo.setPsid(psid);
		 return userDetailsRepository.save(userDetailedInfo);
	}

	
	@RequestMapping(path = "/employeeSignUpInfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<User> retrieveEmployeeSignUpInfoUsingPSID(@RequestParam String userName) {

		return new ResponseEntity<User>(userRepository.getUserByUserName(userName),HttpStatus.OK);

	}

	
	
 @SuppressWarnings({ "unchecked", "rawtypes" })
@RequestMapping(path = "/RegisteredEmployeeInfo/{peopleSoftId}", method =RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces= "application/json") 
 public ResponseEntity retrieveEmployeeFullInfoUsingPSID( @PathVariable("peopleSoftId") String peopleSoftId, UserDetailedInfo userDetailedInfo) {
	  
	  User user = userRepository.getUserByUserName( peopleSoftId );
	  UserDetailedInfo userDetails=userDetailsRepository.getUserByPSID(peopleSoftId);
	  return new ResponseEntity( new UserFullInfo(user, userDetails),HttpStatus.OK);
	 	
	}
}