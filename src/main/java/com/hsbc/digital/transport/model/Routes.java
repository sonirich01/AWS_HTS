package com.hsbc.digital.transport.model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="all details about routes")
@Entity
@Table(name="routes")
@SecondaryTables({
	@SecondaryTable(name="boarding_locations" ,pkJoinColumns=@PrimaryKeyJoinColumn(name="routes_id")),
	@SecondaryTable(name="drop_locations" ,pkJoinColumns=@PrimaryKeyJoinColumn(name="routes_id"))
})

public class Routes {




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;


	@ApiModelProperty(example="locationName",required =true,position=1)
	@Column(length=10)
	private String locationName;
	
	
	@ApiModelProperty(example="routeNumber",required =true,position=2)
	@Column(length=3,unique=true)
	private String routeNumber;
	
	
	@ApiModelProperty(example="routeName",required =true,position=3)
	@Column(length=30,unique=true)
	private String routeName;
	
	@ApiModelProperty(example="busCapacity",required =true,position=4)
	@Column(length=5)
	private String busCapacity;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public String getRouteNumber() {
		return routeNumber;
	}


	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
	}


	public String getRouteName() {
		return routeName;
	}


	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}


	public String getBusCapacity() {
		return busCapacity;
	}


	public void setBusCapacity(String busCapacity) {
		this.busCapacity = busCapacity;
	}

	
	
//////////////////////////////////////////////////////////////////////////	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation1")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation1;

	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation2")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation2;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation3")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation3;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation4")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation4;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation5")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation5;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation6")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation6;
	
	
    ArrayList<String> boradingLocations;
	
	public ArrayList<String> getBoradingLocations() {
		return boradingLocations;
	}


	public void setBoradingLocations(ArrayList<String> boradingLocations) {
		this.boradingLocations = boradingLocations;
	}

	@JsonIgnore
	public String getBoardingLocation1() {
		return boardingLocation1;
	}


	public void setBoardingLocation1(String boardingLocation1) {
		this.boardingLocation1 = boardingLocation1;
	}

	@JsonIgnore
	public String getBoardingLocation2() {
		return boardingLocation2;
	}


	public void setBoardingLocation2(String boardingLocation2) {
		this.boardingLocation2 = boardingLocation2;
	}

	@JsonIgnore
	public String getBoardingLocation3() {
		return boardingLocation3;
	}


	public void setBoardingLocation3(String boardingLocation3) {
		this.boardingLocation3 = boardingLocation3;
	}

	@JsonIgnore
	public String getBoardingLocation4() {
		return boardingLocation4;
	}


	public void setBoardingLocation4(String boardingLocation4) {
		this.boardingLocation4 = boardingLocation4;
	}

	@JsonIgnore
	public String getBoardingLocation5() {
		return boardingLocation5;
	}


	public void setBoardingLocation5(String boardingLocation5) {
		this.boardingLocation5 = boardingLocation5;
	}

	@JsonIgnore
	public String getBoardingLocation6() {
		return boardingLocation6;
	}


	public void setBoardingLocation6(String boardingLocation6) {
		this.boardingLocation6 = boardingLocation6;
	}

	
	
	///////////////////////////////////////////////////////////
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation1")
	@Column(length=10,table="drop_locations")
	private String dropLocation1;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation2")
	@Column(length=10,table="drop_locations")
	private String dropLocation2;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation3")
	@Column(length=10,table="drop_locations")
	private String dropLocation3;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation4")
	@Column(length=10,table="drop_locations")
	private String dropLocation4;
	
	
    ArrayList<String> dropLocations;
	


	public ArrayList<String> getDropLocations() {
		return dropLocations;
	}


	public void setDropLocations(ArrayList<String> dropLocations) {
		this.dropLocations = dropLocations;
	}

	@JsonIgnore
	public String getDropLocation1() {
		return dropLocation1;
	}

	
	public void setDropLocation1(String dropLocation1) {
		this.dropLocation1 = dropLocation1;
	}

	@JsonIgnore
	public String getDropLocation2() {
		return dropLocation2;
	}


	public void setDropLocation2(String dropLocation2) {
		this.dropLocation2 = dropLocation2;
	}

	@JsonIgnore
	public String getDropLocation3() {
		return dropLocation3;
	}


	public void setDropLocation3(String dropLocation3) {
		this.dropLocation3 = dropLocation3;
	}

	@JsonIgnore
	public String getDropLocation4() {
		return dropLocation4;
	}


	public void setDropLocation4(String dropLocation4) {
		this.dropLocation4 = dropLocation4;
	}

	
	
}