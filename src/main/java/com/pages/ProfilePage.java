package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    public static String URL = "https://stellarburgers.nomoreparties.site/account/profile";

    /** Заголовок */
    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    private SelenideElement profileHeader;

    /** Кнопка "Выход" */
    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement exitButton;

    /** Лого */
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    /** Лого конструктора */
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__link__3D_hX")
    private SelenideElement constructorLogo;

    public Boolean isProfileHeaderDisplayed() {
        return profileHeader.shouldBe(Condition.exist, Condition.visible).isDisplayed();
    }

    public LoginPage exitButtonClick() {
        exitButton.click();
        return page(LoginPage.class);
    }

    public MainPage logoClick() {
        logo.click();
        return page(MainPage.class);
    }

    public MainPage constructorLogoClick() {
        constructorLogo.click();
        return page(MainPage.class);
    }
}
