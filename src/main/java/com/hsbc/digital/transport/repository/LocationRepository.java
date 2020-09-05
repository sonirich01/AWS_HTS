package com.hsbc.digital.transport.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hsbc.digital.transport.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

	
	@Query("select u from Location u where u.locationName = ?1")
    Location getDetailsByLocationName(String locationName);
	/*
	/*
	 * Get user list by user name. Please note the format should be
	 * findBy<column_name>.
	 */
	/*
	 * List<User> findByUsername(String username);
	 * 
	 * 
	 * Get user list by user name and password. Please note the format should be
	 * findBy<column_name_1>And<column_name_2>.
	 * 
	 * List<User> findByUsernameAndPassword(String username, String password);
	 * 
	 * @Transactional void deleteByUsernameAndPassword(String userName, String
	 * passWord);
	 * 
	 * @Transactional void deleteByUsername(String userName);
	 */

}