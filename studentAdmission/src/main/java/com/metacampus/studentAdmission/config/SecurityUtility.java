package com.metacampus.studentAdmission.config;


import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {

	/*
	 * can be kept in external file
	 * */
	
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder(){
		//return new BCryptPasswordEncoder(Constants.PASS_STRENGTH,new SecureRandom(Constants.SALT.getBytes()));
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public static String randomPassword(){
		String SALTCHARS="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt=new StringBuilder();
		Random rnd=new Random();
		int index=0;
		while (salt.length()<Constants.RANDOM_PASS_LENGTH){
			index=(int)(rnd.nextFloat()*SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		return salt.toString();
	}
}
