package com.ifisolution.bussiness_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class BussinessManagementApplication {
    @Autowired
    Environment env;

    public static void main(String[] args) {
        SpringApplication.run(BussinessManagementApplication.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Demo Api for Devops Fresher running at port " + env.getProperty("local.server.port");
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello admin";
    }

}
