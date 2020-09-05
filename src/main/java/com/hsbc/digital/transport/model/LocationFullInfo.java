package com.hsbc.digital.transport.model;

public class LocationFullInfo {
	
	
	private final Building building;
	 private final Location location;

	 public LocationFullInfo( Location location,Building building) {
			super();
			this.building = building;
			this.location = location;
		}

	   public Building getBuilding() { return building; }
	   public Location getLocation() { return location; }   
}
