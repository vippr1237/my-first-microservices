package com.ifisolution.Huy_Trinh_resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HuyTrinhResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuyTrinhResourceApplication.class, args);
	}

}
