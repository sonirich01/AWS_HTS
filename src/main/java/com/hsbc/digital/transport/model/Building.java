package com.hsbc.digital.transport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="all details about Buildings")
@Entity
@Table(name="building")
public class Building {
	
	public Building(long id, String location, String building1, String building2, String building3,
			String building4) {
		super();
		this.id = id;
		this.location = location;
		this.building1 = building1;
		this.building2 = building2;
		this.building3 = building3;
		this.building4 = building4;
	}

	public Building() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	

	@ApiModelProperty(example="pune",required =true,position=1)
	@Column(length=10,unique=true)
	private String location;
	
	@ApiModelProperty(example="Building1",required =true,position=2)
	@Column(length=10)
	private String building1;


	@ApiModelProperty(example="Building2",required =true,position=3)
	@Column(length=10)
	private String building2;
	
	@ApiModelProperty(example="Building3",required =true,position=4)
	@Column(length=10)
	private String building3;
	
	@ApiModelProperty(example="Building4",required =true,position=5)
	@Column(length=10)
	private String building4;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocationName() {
		return location;
	}

	public void setLocationName(String location) {
		this.location = location;
	}

	public String getBuilding1() {
		return building1;
	}

	public void setBuilding1(String building1) {
		this.building1 = building1;
	}

	public String getBuilding2() {
		return building2;
	}

	public void setBuilding2(String building2) {
		this.building2 = building2;
	}

	public String getBuilding3() {
		return building3;
	}

	public void setBuilding3(String building3) {
		this.building3 = building3;
	}

	public String getBuilding4() {
		return building4;
	}

	public void setBuilding4(String building4) {
		this.building4 = building4;
	}

	
}
