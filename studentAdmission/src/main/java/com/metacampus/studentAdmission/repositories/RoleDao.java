package com.metacampus.studentAdmission.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.metacampus.studentAdmission.entities.Role;
import com.metacampus.studentAdmission.entities.RoleType;



@Repository
public interface RoleDao extends PagingAndSortingRepository<Role, Long> {

	Role findByRoleType(RoleType roleType);

	
	
}
