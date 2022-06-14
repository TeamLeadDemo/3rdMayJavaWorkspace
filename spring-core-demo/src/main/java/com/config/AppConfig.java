package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pojo.Address;
import com.pojo.User;

@Configuration
@ComponentScan(basePackages="com.pojo")
public class AppConfig {

	@Bean(name = "user")
	public User returnUser() {
		User myUser = new User();
		myUser.setFirstName("Harry");
		myUser.setLastName("Potter");
		myUser.setAddress(returnAddress());
		return myUser;
	}
	
	@Bean
	public Address returnAddress() {
		return new Address("Atlanta", 30044);
	}
	
}
