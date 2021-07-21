package com.ifisolution.bussiness_management;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"}, features = "classpath:features")
@RunWith(Cucumber.class)
// class này config cucumber + chạy cucumber test trong file stepdefs
public class CucumberIntegrationTest {
}
