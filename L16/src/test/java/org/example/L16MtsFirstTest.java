package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class L16MtsFirstTest extends BaseTest {

    @Test
    public void checkPlaceholdersForAllServices() {
        PaymentPage paymentPage = new PaymentPage(driver);

        assertAll(
                "Проверка всех placeholder'ов для всех услуг",
                () -> {
                    paymentPage.openServiceDropdown();
                    paymentPage.selectService("Услуги связи");
                    assertTrue(paymentPage.checkPlaceholdersForService("Услуги связи"));
                },
                () -> {
                    paymentPage.openServiceDropdown();
                    paymentPage.selectService("Домашний интернет");
                    assertTrue(paymentPage.checkPlaceholdersForService("Домашний интернет"));
                },
                () -> {
                    paymentPage.openServiceDropdown();
                    paymentPage.selectService("Рассрочка");
                    assertTrue(paymentPage.checkPlaceholdersForService("Рассрочка"));
                },
                () -> {
                    paymentPage.openServiceDropdown();
                    paymentPage.selectService("Задолженность");
                    assertTrue(paymentPage.checkPlaceholdersForService("Задолженность"));
                }
        );
    }
}
