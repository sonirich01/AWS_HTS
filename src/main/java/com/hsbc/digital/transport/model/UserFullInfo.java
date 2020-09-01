package com.hsbc.digital.transport.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;


public class UserFullInfo {
	
	
	private final User user;
	 private final UserDetailedInfo userDetailedInfo;

	 public UserFullInfo(User user, UserDetailedInfo userDetailedInfo) {
			super();
			this.user = user;
			this.userDetailedInfo = userDetailedInfo;
		}

	   public User getUser() { return user; }
	   public UserDetailedInfo getUserDetailedInfo() { return userDetailedInfo; }   
}
