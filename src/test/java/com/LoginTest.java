package com;

import com.pages.ForgotPasswordPage;
import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    MainPage mainPage = page(MainPage.class);
    UserOperations userOperations;
    Map<String, String> userData = Collections.emptyMap();

    @BeforeEach
    public void setUp() {
        userOperations = new UserOperations();
        userData = userOperations.register();
    }

    @Test
    public void loginOverEnterButtonTest() {
        mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.loginButtonClick();
        loginPage
                .setEmail(userData.get("email"))
                .setPassword(userData.get("password"))
                .enterButtonClick();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Авторизация прошла не успешно");
    }

    @Test
    public void loginOverProfileButtonTest() {
        mainPage = open(MainPage.URL, MainPage.class);
        mainPage.profileButtonClick();
        LoginPage loginPage = page(LoginPage.class);
        loginPage
                .setEmail(userData.get("email"))
                .setPassword(userData.get("password"))
                .enterButtonClick();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Авторизация прошла не успешно");
    }

    @Test
    public void loginOverEnterLinkOnRegisterPageTest() {
        RegisterPage registerPage = open(RegisterPage.URL, RegisterPage.class);
        LoginPage loginPage = registerPage.enterLinkClick();
        loginPage
                .setEmail(userData.get("email"))
                .setPassword(userData.get("password"))
                .enterButtonClick();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Авторизация прошла не успешно");
    }

    @Test
    public void loginOverEnterLinkOnForgotPasswordPageTest() {
        ForgotPasswordPage forgotPasswordPage = open(ForgotPasswordPage.URL, ForgotPasswordPage.class);
        LoginPage loginPage = forgotPasswordPage.enterLinkClick();
        loginPage
                .setEmail(userData.get("email"))
                .setPassword(userData.get("password"))
                .enterButtonClick();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Авторизация прошла не успешно");
    }

    @AfterEach
    public void tearDown() {
        userOperations.delete();
    }
}
