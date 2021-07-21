package com.ifisolution.bussiness_management;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@CucumberContextConfiguration
@SpringBootTest(classes = {BussinessManagementApplication.class, CucumberIntegrationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//cần tìm hiểu thêm
//class này để config
public class SpringIntegrationTest {
}
