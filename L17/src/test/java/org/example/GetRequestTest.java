package org.example;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestTest {

    @Test
    public void testGetRequest() {
                given()
                        .header("User-Agent", "PostmanRuntime/7.41.2") // Добавляем нужный User-Agent
                        .when()
                        .get("https://postman-echo.com/get")
                        .then()
                        .assertThat()
                        .statusCode(200)  // Проверяем, что статус код 200
                        .body("headers.host", equalTo("postman-echo.com")) // Проверяем поле host
                        .body("headers['user-agent']", equalTo("PostmanRuntime/7.41.2")) // Проверяем поле user-agent
                        .body("url", equalTo("https://postman-echo.com/get"));// Проверяем поле url

    }
}
