package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.ApiClient;

import static org.testng.Assert.*;

public class ApiSteps {

    Response response;
    String endpoint;

    @Given("user sets API endpoint {string}")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("user sends POST request with username {string} and password {string}")
    public void sendRequest(String username, String password) {
        response = ApiClient.login(endpoint, username, password);
    }

    @Then("response status should be {int}")
    public void validateStatus(int statusCode) {
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
        assertEquals(response.getStatusCode(), statusCode);
    }
}