package com.hsbc.digital.transport.model;

public class UserFullInfo {
	
	
	private  User user;
	 private  UserDetailedInfo userDetailedInfo;

	 public UserFullInfo() {
			
	 }
	 
	 public UserFullInfo(User user, UserDetailedInfo userDetailedInfo) {
			super();
			this.user = user;
			this.userDetailedInfo = userDetailedInfo;
		}

	   public User getUser() { return user; }
	   public UserDetailedInfo getUserDetailedInfo() { return userDetailedInfo; }   
}
