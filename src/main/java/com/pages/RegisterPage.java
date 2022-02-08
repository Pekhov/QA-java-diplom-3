package com.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {

    public static String URL = "https://stellarburgers.nomoreparties.site/register";

    /** Поле для ввода имени */
    @FindBy(how = How.XPATH, using = "//div[label[text()='Имя']]/input")
    private SelenideElement nameField;

    /** Поле для ввода Email */
    @FindBy(how = How.XPATH, using = "//div[label[text()='Email']]/input")
    private SelenideElement emailField;

    /** Поле для ввода пароля */
    @FindBy(how = How.XPATH, using = "//div[label[text()='Пароль']]/input")
    private SelenideElement passwordField;

    /** Кнопка "Зарегистрироваться" */
    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    /** Хинт с ошибками */
    @FindBy(how = How.XPATH, using = "//p[@class='input__error text_type_main-default']")
    private SelenideElement errorHint;

    /** Кнопка "Войти" */
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement enterLink;

    public RegisterPage setName(String name) {
        nameField.setValue(name);
        return this;
    }

    public RegisterPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public RegisterPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public LoginPage registerButtonClick() {
        registerButton.click();
        return page(LoginPage.class);
    }

    public SelenideElement errorHint() {
        return errorHint;
    }

    public LoginPage enterLinkClick() {
        enterLink.click();
        return page(LoginPage.class);
    }
}
