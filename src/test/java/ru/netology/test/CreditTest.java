package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CreditPage;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class CreditTest {
    @BeforeEach
    void openPage() {
        open("http://localhost:8080");
    }

    @Test
    void test18_fillCreditFormCard1() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var creditPage = new CreditPage();
        var authInfo = DataHelper.getAuthInfoAllValidApproved();
        creditPage.validPayment(authInfo);
        creditPage.approved();
    }

    @Test //баг
    void test19_fillCreditFormCard2() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var creditPage = new CreditPage();
        var authInfo = DataHelper.getAuthInfoAllValidDeclined();
        creditPage.validPayment(authInfo);
        creditPage.declined();
    }

    @Test
    void test20_notFillCreditForm() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var creditPage = new CreditPage();
        var authInfo = DataHelper.getAuthInfoNoData();
        creditPage.validPayment(authInfo);
        creditPage.cardNumberError();
        creditPage.cardMonthError();
        creditPage.cardYearError();
        creditPage.cardHolderError();
        creditPage.cardCVCError();
    }

    @Test //баг?
    void test21_fillCreditFormNotValidCardNumber() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumberNotValid();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        creditPage.declined();
    }

    @Test
    void test22_fillCreditFormNotValidCardNumber15() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumberNotValid15();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        creditPage.cardNumberError();
    }

    @Test //баг?
    void test23_fillCreditFormNotValidCardNumber17() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumberNotValid17();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        creditPage.declined();
    }

    @Test
    void test24_fillCreditFormNotValidFormatCardMonth() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonthNotValidFormat();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        creditPage.cardMonthError();
    }

    @Test
    void test25_fillCreditFormNotValidCardMonth() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonthNotValid();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        creditPage.cardMonthError2();
    }

    @Test
    void test26_fillCreditFormNotValidCardYear() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardYearNotValid1();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        creditPage.cardYearError2();
    }

    @Test
    void test27_fillCreditFormPreviousMonthCurrentYear() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var creditPage = new CreditPage();
        var authInfo = DataHelper.getAuthInfoMonthYear();
        creditPage.validPayment(authInfo);
        creditPage.cardMonthError2();
    }

    @Test
    void test28_fillCreditFormNotValidCardYear2() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardYearNotValid2();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        creditPage.cardYearError3();
    }

    @Test //баг
    void test29_fillCreditFormNotValidCyrillicCardHolder() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolderNotValidCyrillic();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        //я вставила ошибку "Неверный формат", но ее нет на странице
        creditPage.cardHolderError2();
    }

    @Test //баг
    void test30_fillCreditFormNotValidLatinCardHolder() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolderNotValidLatin();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        //я вставила ошибку "Неверный формат", но ее нет на странице
        creditPage.cardHolderError2();
    }

    @Test //баг
    void test31_fillCreditFormNotValidNumbersCardHolder() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolderNotValidNumbers();
        var cardCVC =DataHelper.getCardCVC();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        //я вставила ошибку "Неверный формат", но ее нет на странице
        creditPage.cardHolderError2();
    }

    @Test
    void test32_fillCreditFormNotValidCardCVC() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVCNotValid();
        var creditPage = new CreditPage();
        creditPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        creditPage.cardCVCError();
    }
}
