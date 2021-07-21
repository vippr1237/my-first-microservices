package com.ifisolution.Donal_Trump_resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DonalTrumpResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonalTrumpResourceApplication.class, args);
	}

}
