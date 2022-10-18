package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.data.DBHelper;
import ru.netology.page.MainPage;


import static com.codeborne.selenide.Selenide.open;

public class MainTest {
    @BeforeEach
    void openPage() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
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
