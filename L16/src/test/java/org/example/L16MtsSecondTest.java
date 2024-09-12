package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class L16MtsSecondTest extends BaseTest {

    @Test
    public void testPaymentWindowElements() {
        PaymentPage paymentPage = new PaymentPage(driver);

        // Открытие страницы, выбор услуги и проверка элементов
        paymentPage.openServiceDropdown();
        paymentPage.selectService("Услуги связи");

        String phoneNumber = "297777777";
        String amount = "10";

        paymentPage.enterPhoneNumber(phoneNumber);
        paymentPage.enterAmount(amount);

        // Нажатие на кнопку "Продолжить"
        paymentPage.clickContinueButton();

        assertAll(
                () -> assertTrue(paymentPage.getPhoneNumberFromIFrame().contains("Оплата: Услуги связи Номер:375" + phoneNumber)),
                () -> assertTrue(paymentPage.getAmountFromIFrame().contains(amount + ".00 BYN")),
                () -> assertTrue(paymentPage.getPayButtonTextFromIFrame().contains("Оплатить " + amount + ".00 BYN")),
                () -> assertTrue(paymentPage.isPaymentIconDisplayed("visa")),
                () -> assertTrue(paymentPage.isPaymentIconDisplayed("mastercard")),
                () -> assertTrue(paymentPage.isPaymentIconDisplayed("belkart"))
        );
    }
}
