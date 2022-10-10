package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class CreditPage {
    private SelenideElement cardNumberField = $(byText("Номер карты")).parent().$(".input__control");
    private SelenideElement cardMonthField = $(byText("Месяц")).parent().$(".input__control");
    private SelenideElement cardYearField = $(byText("Год")).parent().$(".input__control");
    private SelenideElement cardHolderField = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement cardCVCField = $(byText("CVC/CVV")).parent().$(".input__control");
    private SelenideElement buttonContinue = $(byText("Продолжить"));
    private SelenideElement cardNumberFieldError = $(byText("Номер карты")).parent().$(".input__sub");
    private SelenideElement cardMonthFieldError = $(byText("Месяц")).parent().$(".input__sub");
    private SelenideElement cardMonthFieldError2 = $(byText("Неверно указан срок действия карты")).parent().$(".input__sub");
    private SelenideElement cardYearFieldError = $(byText("Год")).parent().$(".input__sub");
    private SelenideElement cardYearFieldError2 = $(byText("Истёк срок действия карты")).parent().$(".input__sub");
    private SelenideElement cardYearFieldError3 = $(byText("Неверно указан срок действия карты")).parent().$(".input__sub");
    private SelenideElement cardHolderFieldError = $(byText("Владелец")).parent().$(".input__sub");
    private SelenideElement cardHolderFieldError2 = $(byText("Неверный формат")).parent().$(".input__sub");
    private SelenideElement cardCVCFieldError = $(byText("CVC/CVV")).parent().$(".input__sub");
    private SelenideElement approvedAnswer = $(byText("Операция одобрена Банком.")).parent().$(".notification__icon");
    private SelenideElement declinedAnswer = $(byText("Ошибка! Банк отказал в проведении операции.")).parent().$(".notification__icon");

    public void validPayment(DataHelper.AuthInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        cardMonthField.setValue(info.getCardMonth());
        cardYearField.setValue(info.getCardYear());
        cardHolderField.setValue(info.getCardHolder());
        cardCVCField.setValue(info.getCardCVC());
        buttonContinue.click();
    }

    public void differentValuesPayment(String cardNumber, String cardMonth, String cardYear, String cardHolder, String cardCVC) {
        cardNumberField.setValue(cardNumber);
        cardMonthField.setValue(cardMonth);
        cardYearField.setValue(cardYear);
        cardHolderField.setValue(cardHolder);
        cardCVCField.setValue(cardCVC);
        buttonContinue.click();
    }

    public void cardNumberError() {
        cardNumberFieldError.shouldBe(Condition.visible);
    }

    public void cardMonthError() {
        cardMonthFieldError.shouldBe(Condition.visible);
    }

    public void cardMonthError2() {
        cardMonthFieldError2.shouldBe(Condition.visible);
    }

    public void cardYearError() {
        cardYearFieldError.shouldBe(Condition.visible);
    }

    public void cardYearError2() {
        cardYearFieldError2.shouldBe(Condition.visible);
    }

    public void cardYearError3() {
        cardYearFieldError3.shouldBe(Condition.visible);
    }

    public void cardHolderError() {
        cardHolderFieldError.shouldBe(Condition.visible);
    }

    public void cardHolderError2() {
        cardHolderFieldError2.shouldBe(Condition.visible);
    }

    public void cardCVCError() {
        cardCVCFieldError.shouldBe(Condition.visible);
    }

    public void approved() {
        approvedAnswer.shouldBe(Condition.visible,ofSeconds(15));
    }

    public void declined() {
        declinedAnswer.shouldBe(Condition.visible,ofSeconds(15));
    }
}
