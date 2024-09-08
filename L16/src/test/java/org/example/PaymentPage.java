package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private Map<String, By> serviceOptions = new HashMap<>();
    private Map<String, Map<String, By>> serviceFields = new HashMap<>();
    private static final Map<String, String> fieldPlaceholders = new HashMap<>();

    static {
        fieldPlaceholders.put("phoneNumberField", "Номер телефона");
        fieldPlaceholders.put("subscriberNumberField", "Номер абонента");
        fieldPlaceholders.put("accountNumberFieldInstallment", "Номер счета на 44");
        fieldPlaceholders.put("accountNumberFieldDebt", "Номер счета на 2073");
        fieldPlaceholders.put("amountField", "Сумма");
        fieldPlaceholders.put("emailField", "E-mail для отправки чека");
    }

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        initializeServiceLocators();
        initializeFieldLocators();
    }

    private void initializeServiceLocators() {
        serviceOptions.put("Услуги связи", By.xpath("//p[text()='Услуги связи']"));
        serviceOptions.put("Домашний интернет", By.xpath("//p[text()='Домашний интернет']"));
        serviceOptions.put("Рассрочка", By.xpath("//p[text()='Рассрочка']"));
        serviceOptions.put("Задолженность", By.xpath("//p[text()='Задолженность']"));
    }

    private void initializeFieldLocators() {
        serviceFields.put("Услуги связи", Map.of(
                "phoneNumberField", By.id("connection-phone"),
                "amountField", By.id("connection-sum"),
                "emailField", By.id("connection-email")
        ));

        serviceFields.put("Домашний интернет", Map.of(
                "subscriberNumberField", By.id("internet-phone"),
                "amountField", By.id("internet-sum"),
                "emailField", By.id("internet-email")
        ));

        serviceFields.put("Рассрочка", Map.of(
                "accountNumberFieldInstallment", By.id("score-instalment"),
                "amountField", By.id("instalment-sum"),
                "emailField", By.id("instalment-email")
        ));

        serviceFields.put("Задолженность", Map.of(
                "accountNumberFieldDebt", By.id("score-arrears"),
                "amountField", By.id("arrears-sum"),
                "emailField", By.id("arrears-email")
        ));
    }

    public void openServiceDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select__wrapper']"))).click();
    }

    public void selectService(String serviceType) {
        wait.until(ExpectedConditions.elementToBeClickable(serviceOptions.get(serviceType))).click();
    }

    public void checkPlaceholdersForService(String serviceType) {
        serviceFields.get(serviceType).forEach((key, locator) -> {
            String expectedPlaceholder = fieldPlaceholders.get(key);
            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!expectedPlaceholder.equals(field.getAttribute("placeholder"))) {
                throw new AssertionError("Expected placeholder: '" + expectedPlaceholder + "', but found: '" + field.getAttribute("placeholder") + "'");
            }
        });
    }

    public void enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone"))).sendKeys(phoneNumber);
    }

    public void enterAmount(String amount) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum"))).sendKeys(amount);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button__default ']"))).click();
    }

    public String getTextFromIFrame(By frameLocator, By elementLocator) {
        driver.switchTo().frame(wait.until(ExpectedConditions.presenceOfElementLocated(frameLocator)));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator)).getText();
        driver.switchTo().defaultContent();
        return text;
    }
}
