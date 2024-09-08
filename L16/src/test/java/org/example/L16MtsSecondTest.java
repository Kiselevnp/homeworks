package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;


public class L16MtsSecondTest extends BaseTest {

    private PaymentPage paymentPage;

    @Test
    public void testPaymentWindowElements() {
        paymentPage = new PaymentPage(driver);

        // Открытие страницы, выбор услуги и проверка элементов
        paymentPage.openServiceDropdown();
        paymentPage.selectService("Услуги связи");

        String phoneNumber = "297777777";
        paymentPage.enterPhoneNumber(phoneNumber);
        String amount = "10";
        paymentPage.enterAmount(amount);

        // Нажатие на кнопку "Продолжить"
        paymentPage.clickContinueButton();

        String actualPhoneNumber = paymentPage.getTextFromIFrame(
                By.xpath("//iframe[contains(@src, 'bepaid.by/widget_v2')]"),
                By.xpath("//span[contains(text(),'Номер:')]")
        );
        assertTrue(actualPhoneNumber.contains("Оплата: Услуги связи Номер:375" + phoneNumber),
                "Номер телефона в фрейме отображается некорректно!"
        );
        String actualAmount = paymentPage.getTextFromIFrame(
                By.xpath("//iframe[contains(@src, 'bepaid.by/widget_v2')]"),
                By.xpath("//span[contains(text(),'BYN')]")
        );
        assertTrue(actualAmount.contains(amount + ".00 BYN"),
                "Сумма в фрейме отображается некорректно!"
        );
        String payButtonText = paymentPage.getTextFromIFrame(
                By.xpath("//iframe[contains(@src, 'bepaid.by/widget_v2')]"),
                By.xpath("//button[contains(text(), 'Оплатить') and contains(text(), 'BYN')]")
        );
        assertTrue(payButtonText.contains("Оплатить " + amount + ".00 BYN"),
                "Надпись на кнопке 'Оплатить' не соответствует введенной сумме!");

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'bepaid.by/widget_v2')]")));
        assertTrue(driver.findElement(By.xpath("//img[contains(@src, 'visa-system.svg')]")).isDisplayed(),
                "Иконка Visa не отображается на странице!");
        assertTrue(driver.findElement(By.xpath("//img[contains(@src, 'mastercard-system.svg')]")).isDisplayed(),
                "Иконка MasterCard не отображается на странице!");
        assertTrue(driver.findElement(By.xpath("//img[contains(@src, 'belkart-system.svg')]")).isDisplayed(),
                "Иконка Belkart не отображается на странице!");
        driver.switchTo().defaultContent();
    }
}
