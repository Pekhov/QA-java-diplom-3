package com;

import com.model.User;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.RegisterPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {

    MainPage mainPage;
    User user;

    @BeforeEach
    public void setUp() {
        mainPage = open(MainPage.URL, MainPage.class);
        user = new User()
                .setName(RandomStringUtils.randomAlphabetic(20))
                .setEmail(RandomStringUtils.randomAlphabetic(15) + "@mail.ru")
                .setPassword(RandomStringUtils.randomAlphabetic(15));
    }

    @Test
    public void registrationTest() {
        LoginPage loginPage = mainPage.loginButtonClick();
        RegisterPage registerPage = loginPage.registerButtonClick();
        registerPage
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .registerButtonClick();
        loginPage
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .enterButtonClick();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Регистрация прошла не успешно");
        user.setRegistered(true);
    }

    @Test
    public void registrationWithBadPasswordTest() {
        user.setPassword(RandomStringUtils.randomAlphabetic(5));
        LoginPage loginPage = mainPage.loginButtonClick();
        RegisterPage registerPage = loginPage.registerButtonClick();
        registerPage
                .setName(user.getName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .registerButtonClick();
        registerPage.errorHint().shouldHave(text("Некорректный пароль"));
    }

    @AfterEach
    public void tearDown() {
        if(user.isRegistered()) mainPage.profileButtonClick().exitButtonClick();
    }

}
