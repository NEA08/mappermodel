package com.zensar.login;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zensar.login.entity.User;

@SpringBootApplication

@ComponentScan(basePackages="com.zensar")
//@EnableJpaRepositories

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.crud.example.repository")
public class OlxLoginApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}
   
	public static void main(String[] args) {
		SpringApplication.run(OlxLoginApplication.class, args);
		User user=new User();
		user.getUserName();
		user.getPassword();
		//user.setPassword(toString());
	}
	
	@Bean
	//gives error entityManagerFactory defined in class path rechecks after writing all mappings
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
