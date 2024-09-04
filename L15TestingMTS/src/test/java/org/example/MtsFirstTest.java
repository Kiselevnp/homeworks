package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsFirstTest extends BaseTest {

    @Test
    public void testBlockTitle() {
        WebDriver driver = getDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'pay__wrapper')]//h2")
            ));
            String actualTitle = blockTitle.getText().trim().replaceAll("\\s+", " ");
            String expectedTitle = "Онлайн пополнение без комиссии";

            assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожиданиям.");
        } catch (AssertionError e) {
            throw new AssertionError("Ошибка проверки названия блока: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении теста: " + e.getMessage(), e);
        }
    }
}
