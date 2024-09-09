package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

public class DeleteRequestTest {

    @Test
    public void testDeleteRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/delete"))
                .body("headers.content-type", containsString("text/plain"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}
