package com.hsbc.digital.transport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="all details about locations")
	@Entity
	@Table(name="location")
    @SecondaryTable(name="building" ,pkJoinColumns=@PrimaryKeyJoinColumn(name="location_id"))
	public class Location {
		
		public Location() {
			
		}
	

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;


		@ApiModelProperty(example="locationName",required =true,position=1)
		@Column(length=10,unique=true)
		private String locationName;
	

		@ApiModelProperty(example="cost",required =true,position=2)
		@Column(length=10)
		private String cost;
		
		@ApiModelProperty(example="comments",required =true,position=3)
		@Column(length=10)
		private String comments;
		
	
	
		@ApiModelProperty(example="Building1")
		@Column(length=10,table="building")
		private String building1;
	
	
		@ApiModelProperty(example="Building2")
		@Column(length=10,table="building")
		private String building2;
		
		@ApiModelProperty(example="Building3")
		@Column(length=10,table="building")
		private String building3;
		
		@ApiModelProperty(example="Building4")
		@Column(length=10,table="building")
		private String building4;
		

		

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

		
		public String getCost() {
			return cost;
		}

		public void setCost(String cost) {
			this.cost = cost;
		}

		public String getComments() {
			return comments;
		}
		
		

		public void setComments(String comments) {
			this.comments = comments;
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

