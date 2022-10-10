package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.page.MainPage;


import static com.codeborne.selenide.Selenide.open;

public class MainTest {
    @BeforeEach
    void openPage() {
        open("http://localhost:8080");
    }

    @Test
    void test1_shouldOpenPagePayment() {
        var mainPage = new MainPage();
        mainPage.buyPayment();
        mainPage.sheetPayment();
    }

    @Test
    void test2_shouldOpenPageCredit() {
        var mainPage = new MainPage();
        mainPage.buyCredit();
        mainPage.sheetCredit();
    }
}
