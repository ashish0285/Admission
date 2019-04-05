package com.metacampus.studentAdmission.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
public class HttpSessionConfig {
	
	@Bean
	LettuceConnectionFactory ConnectionFactory(){
		return new LettuceConnectionFactory();
	}

}