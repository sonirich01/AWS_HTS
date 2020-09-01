package com.hsbc.digital.transport.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Additional details about user")
@Entity
@Table(name="userDetails")
public class UserDetailedInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ApiModelProperty(example="4502312322",required =true,position=1)
	@Column(length=10,unique=true)
	private String psid;
	


	@ApiModelProperty(example="soni",required =true,position=2 )
	@Column(length=50)
	private String lineManager;
	
	@ApiModelProperty(example="rbwm",required =true,position=3 )
	@Column(length=10)
	private String department;
	
	@ApiModelProperty(example="manager",required =true,position=4 )
	@Column(length=10)
	private String designation;
	
	@ApiModelProperty(example="parkstreet",required =true,position=5 )
	@Column(length=100)
	private String address;
	

	@ApiModelProperty(example="1234567",required =true,position=6 )
	@Column(length=10)
	private String emergencyContactNumber;
	
	@ApiModelProperty(example="1234567",required =true,position=7 )
	@Column(length=10)
	private String extensionNumber;
    
	public UserDetailedInfo() {
		
	}


	public UserDetailedInfo(long id,String psid, String lineManager, String department, String designation, String address,
			String emergencyContactNumber, String extensionNumber) {
		super();
		this.id = id;
		this.psid=psid;
		this.lineManager = lineManager;
		this.department = department;
		this.designation = designation;
		this.address = address;
		this.emergencyContactNumber = emergencyContactNumber;
		this.extensionNumber = extensionNumber;
	}


	public void setPsid(String psid) {
		this.psid = psid;
	}


	public String getPsid() {
		return psid;
	}


	public String getLineManager() {
		return lineManager;
	}

	public void setLineManager(String lineManager) {
		this.lineManager = lineManager;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}

	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getExtensionNumber() {
		return extensionNumber;
	}

	public void setExtensionNumber(String extensionNumber) {
		this.extensionNumber = extensionNumber;
	}
	

}
