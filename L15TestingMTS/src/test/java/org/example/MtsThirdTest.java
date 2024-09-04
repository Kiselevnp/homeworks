package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsThirdTest extends BaseTest {

    @Test
    public void testServiceLink() {

        WebDriver driver = getDriver();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement serviceLink = driver.findElement(By.xpath("//a[contains(@href, 'help/poryadok')]"));
            serviceLink.click();
            wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
            String actualUrl = driver.getCurrentUrl();
            String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
            assertEquals(expectedUrl, actualUrl, "URL после перехода по ссылке не соответствует ожидаемому.");

        } catch (Exception e) {
            throw new RuntimeException("Ошибка во время теста 'testServiceLink': " + e.getMessage(), e);
        }
    }
}
