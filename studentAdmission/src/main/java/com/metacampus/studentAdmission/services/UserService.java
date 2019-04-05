package com.metacampus.studentAdmission.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacampus.studentAdmission.entities.Role;
import com.metacampus.studentAdmission.entities.RoleType;
import com.metacampus.studentAdmission.entities.User;
import com.metacampus.studentAdmission.repositories.RoleDao;
import com.metacampus.studentAdmission.repositories.UserDao;


@Service
public class UserService  implements UserDetailsService{

	@Autowired
	protected UserDao userDao;
	
	@Autowired
	protected RoleDao roleDao;
	
	@Override
	public UserDetails loadUserByUsername(String loginid) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if (loginid==null) return null;
		
		return userDao.findByLoginid(loginid);
	}
	
	@Transactional
	public User createUser(User user, RoleType roleType) {
		
		if(user==null) return null;
		User tempUser=(User)loadUserByUsername(user.getLoginid());
		if(tempUser!=null) {
			System.out.println("User Already exist!!!");
			Role role=roleDao.findByRoleType(roleType);
			if (role==null) {
				role=new Role();
				role.setRoleType(roleType);
				roleDao.save(role);
			}
			tempUser.setRole(role);
			return tempUser;
		}
		Role role=roleDao.findByRoleType(roleType);
		if (role==null) {
			role=new Role();
			role.setRoleType(roleType);
			roleDao.save(role);
		}
		user.setRole(role);
		userDao.save(user);
		return user;
	}

}
