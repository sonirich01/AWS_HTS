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
	@SecondaryTable(name="drop_locations" ,pkJoinColumns=@PrimaryKeyJoinColumn(name="routes_id")),
	@SecondaryTable(name="route_registration",pkJoinColumns=@PrimaryKeyJoinColumn(name="routes_id"))
})

public class Routes {




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;


	@ApiModelProperty(example="locationName",required =true,position=1)
	@Column(length=50)
	private String locationName;
	
	
	@ApiModelProperty(example="routeNumber",required =true,position=2)
	@Column(length=3)
	private String routeNumber;
	
	
	@ApiModelProperty(example="routeName",required =true,position=3)
	@Column(length=30)
	private String routeName;
	
	@ApiModelProperty(example="busCapacity",required =true,position=4)
	@Column(length=5)
	private String busCapacity;
	
	



	@ApiModelProperty(example="cost",required =true,position=5)
	@Column(length=10)
	private String cost;
	
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

	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
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
	
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation7")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation7;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation8")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation8;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation9")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation9;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="boardingLocation10")
	@Column(length=500,table="boarding_locations")
	private String boardingLocation10;
	
	
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

	@JsonIgnore
	public String getBoardingLocation7() {
		return boardingLocation7;
	}


	public void setBoardingLocation7(String boardingLocation7) {
		this.boardingLocation7 = boardingLocation7;
	}

	@JsonIgnore
	public String getBoardingLocation8() {
		return boardingLocation8;
	}


	public void setBoardingLocation8(String boardingLocation8) {
		this.boardingLocation8 = boardingLocation8;
	}

	@JsonIgnore
	public String getBoardingLocation9() {
		return boardingLocation9;
	}


	public void setBoardingLocation9(String boardingLocation9) {
		this.boardingLocation9 = boardingLocation9;
	}

	@JsonIgnore
	public String getBoardingLocation10() {
		return boardingLocation10;
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
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation5")
	@Column(length=10,table="drop_locations")
	private String dropLocation5;
	
	

	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation6")
	@Column(length=10,table="drop_locations")
	private String dropLocation6;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation7")
	@Column(length=10,table="drop_locations")
	private String dropLocation7;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation8")
	@Column(length=10,table="drop_locations")
	private String dropLocation8;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation9")
	@Column(length=10,table="drop_locations")
	private String dropLocation9;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="dropLocation10")
	@Column(length=10,table="drop_locations")
	private String dropLocation10;
	
	
	
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


	@JsonIgnore
	public String getDropLocation5() {
		return dropLocation5;
	}


	public void setDropLocation5(String dropLocation5) {
		this.dropLocation5 = dropLocation5;
	}


	@JsonIgnore
	public String getDropLocation6() {
		return dropLocation6;
	}


	public void setDropLocation6(String dropLocation6) {
		this.dropLocation6 = dropLocation6;
	}


	@JsonIgnore
	public String getDropLocation7() {
		return dropLocation7;
	}


	public void setDropLocation7(String dropLocation7) {
		this.dropLocation7 = dropLocation7;
	}


	@JsonIgnore
	public String getDropLocation8() {
		return dropLocation8;
	}


	public void setDropLocation8(String dropLocation8) {
		this.dropLocation8 = dropLocation8;
	}


	@JsonIgnore
	public String getDropLocation9() {
		return dropLocation9;
	}


	public void setDropLocation9(String dropLocation9) {
		this.dropLocation9 = dropLocation9;
	}


	@JsonIgnore
	public String getDropLocation10() {
		return dropLocation10;
	}


	public void setDropLocation10(String dropLocation10) {
		this.dropLocation10 = dropLocation10;
	}


	public void setBoardingLocation10(String boardingLocation10) {
		this.boardingLocation10 = boardingLocation10;
	}

/////////////////////////////////////////////////
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="location")
	@Column(length=10,table="route_registration")
	private String location;
	
	
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="location")
	@Column(length=10,table="route_registration")
	private String routeNo;
	
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="location")
	@Column(length=10,table="route_registration")
	private String capacity;
	
	@JsonIgnore
	@JsonProperty(access=Access.WRITE_ONLY)
	@ApiModelProperty(example="location")
	@Column(length=10,table="route_registration")
	private String updatedCapacity;
	
	@JsonIgnore
	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}

	@JsonIgnore
	public String getRouteNo() {
		return routeNo;
	}

	
	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}

	@JsonIgnore
	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	@JsonIgnore
	public String getUpdatedCapacity() {
		return updatedCapacity;
	}


	public void setUpdatedCapacity(String updatedCapacity) {
		this.updatedCapacity = updatedCapacity;
	}

	
}