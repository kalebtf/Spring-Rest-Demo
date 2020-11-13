package com.example.demo;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)
	{

		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Mapper mapper() {
		return new DozerBeanMapper();
	}

}
