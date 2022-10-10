package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    private static Faker fakerEn = new Faker(new Locale("en"));
    private static Faker fakerRu = new Faker(new Locale("ru"));

    @Value
    public static class AuthInfo {
        private String cardNumber;
        private String cardMonth;
        private String cardYear;
        private String cardHolder;
        private String cardCVC;
    }

    public static AuthInfo getAuthInfoAllValidApproved() {
        return new AuthInfo(getCardNumber1(), getCardMonth(), getCardNextYear(), getCardHolder(), getCardCVC());
    }

    public static AuthInfo getAuthInfoAllValidDeclined() {
        return new AuthInfo(getCardNumber2(), getCardMonth(), getCardNextYear(), getCardHolder(), getCardCVC());
    }

    public static AuthInfo getAuthInfoNoData() {
        return new AuthInfo("", "", "", "", "");
    }

    public static AuthInfo getAuthInfoMonthYear() {
        return new AuthInfo(getCardNumber1(), getCardPreviousMonth(), getCardCurrentYear(), getCardHolder(), getCardCVC());
    }

    public static String getCardNumber1() {
        return "4444444444444441";
    }

    public static String getCardNumber2() {
        return "4444444444444442";
    }

    public static String getCardNumberNotValid() {
        return "1234567812345678";
    }

    public static String getCardNumberNotValid15() {
        return "555555555555555";
    }

    public static String getCardNumberNotValid17() {
        return "77777777777777777";
    }

    public static String getCardMonth() {
        return "05";
    }

    public static String getCardMonthNotValidFormat() {
        return "5";
    }

    public static String getCardMonthNotValid() {
        return "55";
    }

    public static String getCardPreviousMonth() {
        int currentMonth = LocalDate.now().getMonthValue();
        if (currentMonth == 1) {
            return "12";
        } else {
            return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
        }
    }

    public static String getCardYearNotValid1() {
        return "00";
    }

    public static String getCardYearNotValid2() {
        return "88";
    }

    public static String getCardCurrentYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getCardNextYear() {
        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getCardHolder() {
        return fakerEn.name().firstName() + " " + fakerEn.name().lastName();
    }

    public static String getCardHolderNotValidCyrillic() {
        return fakerRu.name().firstName() + " " + fakerRu.name().lastName();
    }

    public static String getCardHolderNotValidLatin() {
        return "yjhfwkg";
    }

    public static String getCardHolderNotValidNumbers() {
        return "1354/.123][/";
    }

    public static String getCardCVC() {
        return "123";
    }

    public static String getCardCVCNotValid() {
        return "12";
    }
}
