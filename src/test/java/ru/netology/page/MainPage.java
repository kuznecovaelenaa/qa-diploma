package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement buttonPayment = $(byText("Купить"));
    private SelenideElement buttonCredit = $(byText("Купить в кредит"));

    private SelenideElement sheetFieldPayment = $(byText("Оплата по карте"));

    private SelenideElement sheetFieldCredit = $(byText("Кредит по данным карты"));

    public PaymentPage buyPayment() {
        buttonPayment.click();
        return new PaymentPage();
    }

    public CreditPage buyCredit() {
        buttonCredit.click();
        return new CreditPage();
    }

    public void sheetPayment() {
        sheetFieldPayment.shouldBe(Condition.visible);
    }

    public void sheetCredit() {
        sheetFieldCredit.shouldBe(Condition.visible);
    }
}
