package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetRequestTest {

    @Test
    public void testGetRequest() {
        // Устанавливаем базовый URL для RestAssured
        RestAssured.baseURI = "https://postman-echo.com";

        // Выполняем GET-запрос
        Response response = RestAssured
                .given()
                .when()
                .get("/get")
                .then()
                .extract()
                .response();

        // Проверка кода ответа
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode, "Статус код должен быть 200");

        // Проверка тела ответа
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Здесь можно добавить проверку ключей в теле ответа, если ожидаются конкретные данные
    }
}
