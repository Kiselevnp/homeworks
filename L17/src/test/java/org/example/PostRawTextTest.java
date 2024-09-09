package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRawTextTest {

    @Test
    public void testPostRawText() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .contentType("text/plain")
                .body("This is raw text")
                .when()
                .post("/post")
                .then()
                .statusCode(200)  // Ожидаемый код ответа
                .body("data", equalTo("This is raw text"));
    }
}
