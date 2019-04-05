package com.metacampus.studentAdmission.controllers;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacampus.studentAdmission.config.Constants;
import com.metacampus.studentAdmission.context.DataContext;
import com.metacampus.studentAdmission.entities.User;
import com.metacampus.studentAdmission.services.StudentService;
import com.metacampus.studentAdmission.services.UserService;



@CrossOrigin(origins = { "*" }, maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/studentLogin")
public class LoginController {
	@Autowired
	private UserService userService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/token")
	public Map<String,String> getToken(HttpSession session, HttpServletRequest request,Principal principal){
		User user =(User)userService.loadUserByUsername(principal.getName());
		
		request.getSession().removeAttribute(Constants.CONTEXT);
		setDataContext(user, request,session);
		System.out.println("http Session : "+session.getId());
		System.out.println("Tomcat request Session : "+request.getSession().getId());
		System.out.println("requested Session : "+request.getRequestedSessionId());
		System.out.println("token : "+request.getHeader("X-Auth-Token"));
		 session.setMaxInactiveInterval(1800);
		 return Collections.singletonMap("token", session.getId());
			    
	}

	private void setDataContext(User user, HttpServletRequest request, HttpSession session) {
		// TODO Auto-generated method stub
		
		
		 DataContext dataContext=new DataContext();
		 dataContext.setSessionIdentifier(session.getId());
		 dataContext.setUserId(user.getId());
		 dataContext.setRole(user.getRole());
		 //HttpSession mySession= request.getSession();
		 session.removeAttribute(Constants.CONTEXT);
		 session.setAttribute(Constants.CONTEXT, dataContext);
	}

}
