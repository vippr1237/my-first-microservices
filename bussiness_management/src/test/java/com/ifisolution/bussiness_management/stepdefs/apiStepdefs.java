package com.ifisolution.bussiness_management.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class apiStepdefs {
    private String URI = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response;

    @When("^the client call /$")
    public void clientCall() {
        response = restTemplate.getForEntity(URI, String.class);
    }

    @Then("^the client recieves status code of (\\d+)$")
    public void clientReceives(int statusCode) {
        assertThat(statusCode).isEqualTo(response.getStatusCodeValue());
    }

    @And("^the response should be \"([^\"]*)\"$")
    public void clientReceivesReponse(String message) {
        assertThat(message).isEqualTo(response.getBody());
    }
}
