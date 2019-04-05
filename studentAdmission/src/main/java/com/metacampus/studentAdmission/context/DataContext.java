package com.metacampus.studentAdmission.context;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.metacampus.studentAdmission.entities.Role;

@Component
public class DataContext implements Serializable{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4769297685666964207L;

	/**
	 * 
	 */
	
	
	String sessionIdentifier;

	Long userId;
	
	Role role;

	public String getSessionIdentifier() {
		return sessionIdentifier;
	}

	public void setSessionIdentifier(String sessionIdentifier) {
		this.sessionIdentifier = sessionIdentifier;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	
	
	
	
}
