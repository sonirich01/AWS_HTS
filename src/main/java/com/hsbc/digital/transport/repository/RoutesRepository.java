package com.hsbc.digital.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.hsbc.digital.transport.model.Routes;

public interface RoutesRepository extends JpaRepository<Routes, Integer> {
	
	@Query("select u from Routes u where u.locationName = ?1")
    
	List<Routes> getRoutesByLocationName(String locationName);
	
	@Query("select u from Routes u where u.locationName = ?1 and u.routeNumber = ?2")
    Routes getDetailsByLocationNameAndRouteNumber(String locationName,String routeNumber);

}
