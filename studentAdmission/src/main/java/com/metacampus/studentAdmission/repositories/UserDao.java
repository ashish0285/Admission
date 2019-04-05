package com.metacampus.studentAdmission.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.metacampus.studentAdmission.entities.Role;
import com.metacampus.studentAdmission.entities.User;



@Repository
public interface UserDao extends PagingAndSortingRepository<User, Long> {


	
	User findByLoginid(String Loginid);
	

}
