package com.mapper;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApp {

	@Value("${spring.application.name}")
	private String instanceName;


	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class, args);
	}

}
