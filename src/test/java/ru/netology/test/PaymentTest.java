package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.MainPage;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentTest {
    @BeforeEach
    void openPage() {
        open("http://localhost:8080");
    }

    @Test
    void test3_fillPaymentFormCard1() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var paymentPage = new PaymentPage();
        var authInfo = DataHelper.getAuthInfoAllValidApproved();
        paymentPage.validPayment(authInfo);
        paymentPage.approved();
    }

    @Test //баг
    void test4_fillPaymentFormCard2() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var paymentPage = new PaymentPage();
        var authInfo = DataHelper.getAuthInfoAllValidDeclined();
        paymentPage.validPayment(authInfo);
        paymentPage.declined();
    }

    @Test
    void test5_notFillPaymentForm() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var paymentPage = new PaymentPage();
        var authInfo = DataHelper.getAuthInfoNoData();
        paymentPage.validPayment(authInfo);
        paymentPage.cardNumberError();
        paymentPage.cardMonthError();
        paymentPage.cardYearError();
        paymentPage.cardHolderError();
        paymentPage.cardCVCError();
    }

    @Test //баг?
    void test6_fillPaymentFormNotValidCardNumber() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumberNotValid();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        paymentPage.declined();
    }

    @Test
    void test7_fillPaymentFormNotValidCardNumber15() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumberNotValid15();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        paymentPage.cardNumberError();
    }

    @Test //баг?
    void test8_fillPaymentFormNotValidCardNumber17() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumberNotValid17();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        paymentPage.declined();
    }

    @Test
    void test9_fillPaymentFormNotValidFormatCardMonth() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonthNotValidFormat();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        paymentPage.cardMonthError();
    }

    @Test
    void test10_fillPaymentFormNotValidCardMonth() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonthNotValid();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        paymentPage.cardMonthError2();
    }

    @Test
    void test11_fillPaymentFormNotValidCardYear() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardYearNotValid1();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        paymentPage.cardYearError2();
    }

    @Test
    void test12_fillPaymentFormPreviousMonthCurrentYear() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var paymentPage = new PaymentPage();
        var authInfo = DataHelper.getAuthInfoMonthYear();
        paymentPage.validPayment(authInfo);
        paymentPage.cardMonthError2();
    }

    @Test
    void test13_fillPaymentFormNotValidCardYear2() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardYearNotValid2();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        paymentPage.cardYearError3();
    }

    @Test //баг
    void test14_fillPaymentFormNotValidCyrillicCardHolder() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolderNotValidCyrillic();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        //я вставила ошибку "Неверный формат", но ее нет на странице
        paymentPage.cardHolderError2();
    }

    @Test //баг
    void test15_fillPaymentFormNotValidLatinCardHolder() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolderNotValidLatin();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        //я вставила ошибку "Неверный формат", но ее нет на странице
        paymentPage.cardHolderError2();
    }

    @Test //баг
    void test16_fillPaymentFormNotValidNumbersCardHolder() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolderNotValidNumbers();
        var cardCVC =DataHelper.getCardCVC();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        //я вставила ошибку "Неверный формат", но ее нет на странице
        paymentPage.cardHolderError2();
    }

    @Test
    void test17_fillPaymentFormNotValidCardCVC() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        var cardNumber = DataHelper.getCardNumber1();
        var cardMonth =DataHelper.getCardMonth();
        var cardYear =DataHelper.getCardNextYear();
        var cardHolder =DataHelper.getCardHolder();
        var cardCVC =DataHelper.getCardCVCNotValid();
        var paymentPage = new PaymentPage();
        paymentPage.differentValuesPayment(cardNumber, cardMonth, cardYear,cardHolder, cardCVC);
        paymentPage.cardCVCError();
    }
}