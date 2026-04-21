package utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    private static final String BASE_URL = "https://dummyjson.com";

    public static Response login(String endpoint, String username, String password) {

        String body = "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }";

        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(BASE_URL + endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}