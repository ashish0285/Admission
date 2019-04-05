package com.metacampus.studentAdmission.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import com.metacampus.studentAdmission.entities.RoleType;
import com.metacampus.studentAdmission.services.UserService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


		
	@Autowired
	private UserService userService;
	
	private BCryptPasswordEncoder passwordEncoder(){
		return SecurityUtility.passwordEncoder();
	}
	
		
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
			.cors()
			.and()
			.csrf()
				.disable()
			.httpBasic()
			.and()
			.authorizeRequests()
				.antMatchers(Constants.PUBLIC_MATCHERS).permitAll()
				.antMatchers("/security/**").authenticated()
				.antMatchers("/studentLogin/**").hasAuthority(RoleType.STUDENT.toString())
				.antMatchers("/admin/**").hasAuthority(RoleType.ADMIN.toString())
				.anyRequest()
				.authenticated();
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public HttpSessionStrategy httpSessionStrategy(){
		return new HeaderHttpSessionStrategy();
	}
}
