package br.com.agrisource.logistics_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LogisticsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsServiceApplication.class, args);
	}

}
