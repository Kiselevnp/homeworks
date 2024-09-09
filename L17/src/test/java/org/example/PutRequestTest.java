package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class PutRequestTest {

    @Test
    public void testPutRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.content-type", containsString("text/plain"));
    }
}
