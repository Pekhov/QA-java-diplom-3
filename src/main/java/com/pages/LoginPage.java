package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public static String URL = "https://stellarburgers.nomoreparties.site/login";

    /** Заголовок */
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement enterHeader;

    /** Поле для ввода Email */
    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private SelenideElement emailField;

    /** Поле для ввода пароля */
    @FindBy(how = How.XPATH, using = "//div[label[text()='Пароль']]/input")
    private SelenideElement passwordField;

    /** Кнопка "Войти" */
    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement enterButton;

    /** Кнопка "Зарегистрироваться" */
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registerButton;

    public Boolean isEnterHeaderDisplayed() {
        return emailField.shouldBe(Condition.exist, Condition.visible).isDisplayed();
    }

    public LoginPage setEmail(String email) {
        emailField.shouldBe(Condition.exist, Condition.visible).clear();
        emailField.setValue(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.clear();
        passwordField.setValue(password);
        return this;
    }

    public MainPage enterButtonClick() {
        enterButton.click();
        return page(MainPage.class);
    }

    public RegisterPage registerButtonClick() {
        registerButton.click();
        return page(RegisterPage.class);
    }
}
