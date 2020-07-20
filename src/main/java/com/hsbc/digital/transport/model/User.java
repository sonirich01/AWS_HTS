package com.hsbc.digital.transport.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="all details about user")
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ApiModelProperty(example="virat",required =true,position=1)
	@NotBlank(message="first name is mandatory")
	@Column(length=60)
	private String firstName;
	
	@ApiModelProperty(example="koli",required =true,position=2)
	@NotBlank(message="last name is mandatory")
	@Column(length=60)
	private String lastName;
	
	@ApiModelProperty(example="koli",required =true,position=3)
	@Column(unique=true)
	@NotBlank(message="user name is mandatory")
	private String userName;
	
	@ApiModelProperty(example="koli12",required =true,position=4)
	@Column(length=60)
	@NotBlank(message="password is mandatory")
	private String passWord;
	
	@ApiModelProperty(example="koli12@hsbc.com",required =true,position=5)
	@Column(length=60)
	@NotBlank(message="email is mandatory")
	private String emailId;
	
	@ApiModelProperty(example="99343242",required =true,position=6)
	@Column(length=10)
	private String phoneNumber;
	
	@ApiModelProperty(example="user",required =true,position=7)
	@Column(length=10)
	private String role;
	
	
	

	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
	private Set<Role>roles;
	
	public User() {
		
	}
	
	public User(long id, String firstName, String lastName, String userName, String password, String email,
			String phoneNumber,String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = password;
		this.emailId = email;
		this.phoneNumber = phoneNumber;
		this.role=role;
	
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return passWord;
	}
	public void setPassword(String password) {
		this.passWord = password;
	}
	public String getEmail() {
		return emailId;
	}
	public void setEmail(String email) {
		this.emailId = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + passWord + ", email=" + emailId + ", phoneNumber=" + phoneNumber +  
				 ", role=" + role + "]";
	}
}
