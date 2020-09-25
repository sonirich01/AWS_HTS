package com.hsbc.digital.transport.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hsbc.digital.transport.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	 @Query("select u from User u where u.userName = ?1")
      User getUserByUserName(String userName);
	 
	 @Query("select u from User u where u.userName = ?1 AND u.passWord = ?2")
     User getUserByUserNameAndPassword(String userName,String password);
	 
	 @Query("select u from User u where u.userName = :userName and u.passWord = :passWord")
	  User findByUserNameOrPassWord(@Param("userName") String userName,
	                                 @Param("passWord") String passWord);
	  
	
    @Transactional
	@Modifying
	@Query(value="delete u from User u where u.user_name = ?1",nativeQuery=true)
	void deleteUserByPSID(String userName) ;
	
   }
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

