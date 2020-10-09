package com.hsbc.digital.transport.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hsbc.digital.transport.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

	
	@Query("select u from Location u where u.locationName = ?1")
    Location getDetailsByLocationName(String locationName);
	
	 @Transactional
	 @Modifying
	 @Query(value="update Location u set u.cost=?1,u.comments=?2,u.building1=?3,u.building2=?4,u.building3=?5,u.building4=?6 where u.locationName = ?7")
	 int UpdateUserInfoByPSID(String cost,String comments,String building1,String building2,String building3,String building4,String locationName);
	
	 
	 @Transactional
	 @Modifying
	 @Query(value="delete u from location u where u.location_name = ?1",nativeQuery=true)
	 void deleteUserBylocationName(String locationName);
	 
	 
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