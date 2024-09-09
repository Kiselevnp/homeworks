package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class PatchRequestTest {

    @Test
    public void testPatchRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .body("headers.content-type", containsString("text/plain"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}

