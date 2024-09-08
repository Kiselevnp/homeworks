package org.example;

import org.junit.jupiter.api.Test;

public class L16MtsFirstTest extends BaseTest {

    @Test
    public void testPlaceholdersForAllServices() {
        PaymentPage paymentPage = new PaymentPage(getDriver());

        paymentPage.openServiceDropdown();
        paymentPage.selectService("Услуги связи");
        paymentPage.checkPlaceholdersForService("Услуги связи");

        paymentPage.openServiceDropdown();
        paymentPage.selectService("Домашний интернет");
        paymentPage.checkPlaceholdersForService("Домашний интернет");

        paymentPage.openServiceDropdown();
        paymentPage.selectService("Рассрочка");
        paymentPage.checkPlaceholdersForService("Рассрочка");

        paymentPage.openServiceDropdown();
        paymentPage.selectService("Задолженность");
        paymentPage.checkPlaceholdersForService("Задолженность");
    }
}
