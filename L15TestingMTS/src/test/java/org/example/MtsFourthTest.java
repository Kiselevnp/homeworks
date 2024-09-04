package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;

public class MtsFourthTest extends BaseTest {

    @Test
    public void testContinueButtonFunctionality() {
        WebDriver driver = getDriver();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            By serviceSelector = By.xpath("//div[@class = 'select__wrapper']");
            By phoneNumberField = By.id("connection-phone");
            By amountField = By.id("connection-sum");
            By continueButton = By.xpath("//button[@class = 'button button__default ']");
            By paymentFrame = By.xpath("//iframe[contains(@src, 'https://pay.yandex.ru/web/sdk/v1/init-2')]");

            WebElement serviceElement = wait.until(ExpectedConditions.elementToBeClickable(serviceSelector));
            serviceElement.click();
            WebElement serviceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class = 'select__now']")));
            serviceOption.click();
            WebElement phoneNumberElement = wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField));
            phoneNumberElement.click();
            phoneNumberElement.sendKeys("297777777");
            WebElement amountElement = wait.until(ExpectedConditions.elementToBeClickable(amountField));
            amountElement.click();
            amountElement.sendKeys("10");

            WebElement continueButtonElement = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
            continueButtonElement.click();

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
            Assertions.assertTrue(true, "Переход на iframe оплаты произошел успешно.");

        } catch (AssertionError e) {
            throw new AssertionError("Ошибка проверки функциональности кнопки 'Продолжить': " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении теста 'testContinueButtonFunctionality': " + e.getMessage(), e);
        }
    }
}
