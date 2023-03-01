package com.app;

import java.util.Properties;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class ProjectTrial02Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTrial02Application.class, args);
	}
	
	@Bean
	public ModelMapper mapper()
	{
		System.out.println("In Model Mapper!!!!");
		return new ModelMapper();
	}
	
	
	
	@Value("${spring.mail.protocol}")
	private String protocol;
	
	@Value("${spring.mail.username}")
	private String userName;
	
	@Value("${spring.mail.password}")
	private String password;
	
	
	
	 @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.gmail.com");
	        mailSender.setPort(587);
	        
	        mailSender.setUsername(userName);
	        mailSender.setPassword(password);
	        
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", protocol);
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");
	        
	        return mailSender;
	    }

}
