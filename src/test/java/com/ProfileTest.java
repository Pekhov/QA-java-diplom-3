package com;

import com.pages.LoginPage;
import com.pages.MainPage;
import com.pages.ProfilePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTest extends BaseTest {

    MainPage mainPage;
    UserOperations userOperations;
    Map<String, String> userData = Collections.emptyMap();

    @BeforeEach
    public void setUp() {
        userOperations = new UserOperations();
        userData = userOperations.register();
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    public void enterProfileTest() {
        LoginPage loginPage = mainPage.loginButtonClick();
        loginPage
                .setEmail(userData.get("email"))
                .setPassword(userData.get("password"))
                .enterButtonClick();
        ProfilePage profilePage = mainPage.profileButtonClick();
        assertTrue(profilePage.isProfileHeaderDisplayed(), "Неудачный переход в личный кабинет");
    }

    @Test
    public void exitFromProfileTest() {
        LoginPage loginPage = mainPage.loginButtonClick();
        loginPage
                .setEmail(userData.get("email"))
                .setPassword(userData.get("password"))
                .enterButtonClick();
        ProfilePage profilePage = mainPage.profileButtonClick();
        profilePage.exitButtonClick();
        assertTrue(loginPage.isEnterHeaderDisplayed(), "Неудачный выход из личного кабинета");
    }

    @Test
    public void logoClickTest() {
        LoginPage loginPage = mainPage.loginButtonClick();
        loginPage
                .setEmail(userData.get("email"))
                .setPassword(userData.get("password"))
                .enterButtonClick();
        ProfilePage profilePage = mainPage.profileButtonClick();
        profilePage.logoClick();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Переход на главную через лого прошел не удачно");
    }

    @Test
    public void constructorLogoClickTest() {
        LoginPage loginPage = mainPage.loginButtonClick();
        loginPage
                .setEmail(userData.get("email"))
                .setPassword(userData.get("password"))
                .enterButtonClick();
        ProfilePage profilePage = mainPage.profileButtonClick();
        profilePage.constructorLogoClick();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Переход на главную через лого прошел не удачно");
    }

    @AfterEach
    public void tearDown() {
        userOperations.delete();
    }
}
