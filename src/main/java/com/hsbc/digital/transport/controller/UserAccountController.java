package com.hsbc.digital.transport.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.hsbc.digital.transport.repository.RoleRepository;
import com.hsbc.digital.transport.repository.UserRepository;

@RestController
public class UserAccountController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DefaultExceptionHandler defaultExceptionHandler;

	@RequestMapping(path = "/employeeRegister/{role}", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = "application/json")
	public User addUser(@Valid @RequestBody User user, @PathVariable("role") String role) {
     
		user.setRole(role);
		return userRepository.save(user);

	}

	@RequestMapping(path = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<User> findUser() {

		return userRepository.findAll();

	}

	
	@RequestMapping(path = "/loginUser", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus
	
	public ResponseEntity<User> loginUser(@RequestParam String userName, @RequestParam String passWord) {
        if((userRepository.getUserByUserNameAndPassword(userName,passWord).equals(null))) {
          throw new RecordNotFoundException("invalid username or password");
		
        }
        else {
        	return new ResponseEntity<User>((userRepository.findByUserNameOrPassWord(userName, passWord)),HttpStatus.OK);
        }
	}
	
	@RequestMapping(value = "/logoutEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String logout() {

		return "logged out successfully";

	}


}