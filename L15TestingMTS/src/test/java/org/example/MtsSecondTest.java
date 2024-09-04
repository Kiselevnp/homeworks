package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsSecondTest extends BaseTest {

    @Test
    public void testPaymentSystemLogos() {
        WebDriver driver = getDriver();

        try {
            By visaLogo = By.xpath("//img[contains(@src, 'visa.svg') and @alt='Visa']");
            By verifiedVisaLogo = By.xpath("//img[contains(@src, 'visa-verified.svg') and @alt='Verified By Visa']");
            By mastercardLogo = By.xpath("//img[contains(@src, 'mastercard.svg') and @alt='MasterCard']");
            By mastercardSecureCodeLogo = By.xpath("//img[contains(@src, 'mastercard-secure.svg') and @alt='MasterCard Secure Code']");
            By belkartLogo = By.xpath("//img[contains(@src, 'belkart.svg') and @alt='Белкарт']");

            checkLogoPresence(driver, visaLogo, "Visa");
            checkLogoPresence(driver, verifiedVisaLogo, "Verified By Visa");
            checkLogoPresence(driver, mastercardLogo, "MasterCard");
            checkLogoPresence(driver, mastercardSecureCodeLogo, "MasterCard Secure Code");
            checkLogoPresence(driver, belkartLogo, "Белкарт");

        } catch (AssertionError e) {
            System.out.println("Ошибка проверки наличия логотипов: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении теста: " + e.getMessage(), e);
        }
    }

    private void checkLogoPresence(WebDriver driver, By logoLocator, String logoName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocator));
            assertTrue(logo.isDisplayed(), "Логотип " + logoName + " не отображается.");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при проверке логотипа " + logoName + ": " + e.getMessage(), e);
        }
    }

}
