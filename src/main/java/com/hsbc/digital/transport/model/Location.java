package com.hsbc.digital.transport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="all details about locations")
	@Entity
	@Table(name="location")
	public class Location {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		
		public Location() {
			
		}
	
		
		public Location(long id, String locationName, String cost, String comments) {
			super();
			this.id = id;
			this.locationName = locationName;
			this.cost = cost;
			this.comments = comments;
		}


		@ApiModelProperty(example="locationName",required =true,position=1)
		@Column(length=10,unique=true)
		private String locationName;
	

		@ApiModelProperty(example="cost",required =true,position=3)
		@Column(length=10)
		private String cost;
		
		@ApiModelProperty(example="comments",required =true,position=3)
		@Column(length=10)
		private String comments;
		
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
}

