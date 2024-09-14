package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        initializeFieldLocators();
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='" + serviceType + "']"))).click();
    }

    public boolean checkPlaceholdersForService(String serviceType) {
        Map<String, By> fields = serviceFields.get(serviceType);
        if (fields == null) {
            return false;
        }

        for (Map.Entry<String, By> field : fields.entrySet()) {
            String expectedPlaceholder = fieldPlaceholders.get(field.getKey());
            String actualPlaceholder = wait.until(ExpectedConditions.visibilityOfElementLocated(field.getValue()))
                    .getAttribute("placeholder");

            if (!expectedPlaceholder.equals(actualPlaceholder)) {
                return false;
            }
        }
        return true;
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

    public String getPhoneNumberFromIFrame() {
        driver.switchTo().frame(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src, 'bepaid.by/widget_v2')]"))));
        String phoneNumberText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Номер:')]"))).getText();
        driver.switchTo().defaultContent();
        return phoneNumberText;
    }

    public String getAmountFromIFrame() {
        driver.switchTo().frame(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src, 'bepaid.by/widget_v2')]"))));
        String amountText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'BYN')]"))).getText();
        driver.switchTo().defaultContent();
        return amountText;
    }

    public String getPayButtonTextFromIFrame() {
        driver.switchTo().frame(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src, 'bepaid.by/widget_v2')]"))));
        String buttonText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Оплатить') and contains(text(), 'BYN')]"))).getText();
        driver.switchTo().defaultContent();
        return buttonText;
    }

    public boolean isPaymentIconDisplayed(String iconType) {
        driver.switchTo().frame(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@src, 'bepaid.by/widget_v2')]"))));
        boolean isDisplayed = driver.findElement(By.xpath("//img[contains(@src, '" + iconType + "-system.svg')]")).isDisplayed();
        driver.switchTo().defaultContent();
        return isDisplayed;
    }
}
