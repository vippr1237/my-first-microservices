package com.ifisolution.bussiness_management.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductStepdefs {
    private String URI = "http://localhost:8080/api/product";
    private RestTemplate restTemplate = new RestTemplate();
    ;
    private ResponseEntity<String> response;
    private HttpHeaders headers;

    @Given("User set POST product service api endpoint")
    public void userSetPOSTProductServiceApiEndpoint() {
        System.out.println("Add URL :" + URI);
    }

    @When("User Set request HEADER")
    public void userSetRequestHEADER() {
        headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
    }

    @And("User send a POST HTTP request")
    public void userSendAPOSTHTTPRequest() {
        String jsonBody = "{\"name\":\"product-01\",\"stock\":50,\"price\":20.0}";
        System.out.println("\n\n" + jsonBody);
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
        System.out.println(headers);
        //POST Method to Add New Produc
        response = restTemplate.postForEntity(URI, entity, String.class);
    }

    @Then("User recieves status code of {int}")
    public void userRecievesStatusCodeOf(int statusCode) {
        assertThat(response.getStatusCodeValue()).isEqualTo(statusCode);
    }

    @And("User recieves valid POST response")
    public void userRecievesValidPOSTResponse() {
        String responseBody = "{\"id\":1,\"productName\":\"product-01\",\"quantity\":50,\"price\":20.0}";
        System.out.println("responseBody --->" + responseBody);
        assertThat(responseBody).isEqualTo(response.getBody());
    }

    @When("User send a GET HTTP request")
    public void userSendAGETHTTPRequest() {
        restTemplate = new RestTemplate();
        response = restTemplate.getForEntity(URI, String.class);
    }

    @And("User recieves valid response")
    public void userRecievesValidResponse() {
        String responeBody = "[{\"id\":1,\"name\":\"product-01\",\"stock\":50,\"price\":20.0}]";
        System.out.println("response body: " + responeBody);
        assertThat(responeBody).isEqualTo(response.getBody());
    }

    @And("User send a PUT HTTP request")
    public void userSendAPUTHTTPRequest() {
        String jsonBody = "{\"id\":1,\"name\":\"product-01 updated\",\"stock\":50,\"price\":20.0}";
        System.out.println("\n\n" + jsonBody);
        HttpEntity<String> entity = new HttpEntity<String>(jsonBody, headers);
        response = restTemplate.exchange(URI, HttpMethod.PUT, entity, String.class);
    }

    @And("User recieves valid PUT response")
    public void userRecievesValidPUTResponse() {
        String expected = "{\"id\":1,\"productName\":\"product-01 updated\",\"quantity\":50,\"price\":20.0}";
        System.out.println("responseBody --->" + expected);
        assertThat(expected).isEqualTo(response.getBody());
    }

    @Given("User set DELETE product service api endpoint")
    public void userSetDELETEProductServiceApiEndpoint() {
        URI = URI + "/1";
        System.out.println(URI);
    }

    @When("User send a DELETE HTTP request")
    public void userSendADELETEHTTPRequest() {
        restTemplate = new RestTemplate();
        response = restTemplate.exchange(URI, HttpMethod.DELETE, null, String.class);
    }

    @And("User will recieves a message {string}")
    public void userWillRecievesAMessage(String message) {
        assertThat(response.getBody()).isEqualTo(message);
    }
}
