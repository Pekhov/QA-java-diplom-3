package com.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static String URL = "https://stellarburgers.nomoreparties.site/";

    /** Кнопка личного кабинета */
    @FindBy(how = How.LINK_TEXT, using = "Личный Кабинет")
    private SelenideElement profileButton;

    /** Кнопка "Войти в аккаунт" */
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    /** Кнопка "Оформить заказ" */
    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    /** Вкладка "Булки" */
    @FindBy(how = How.XPATH, using = "//div[span[text()='Булки']]")
    private SelenideElement bunTab;

    /** Вкладка "Соусы" */
    @FindBy(how = How.XPATH, using = "//div[span[text()='Соусы']]")
    private SelenideElement sauceTab;

    /** Вкладка "Начинки" */
    @FindBy(how = How.XPATH, using = "//div[span[text()='Начинки']]")
    private SelenideElement fillingTab;

    /** Скролл конструктора */
    @FindBy(how = How.XPATH, using = "//h2[@class='text text_type_main-medium mb-6 mt-10']")
    private ElementsCollection scrollHeaders;

    /** Скролл конструктора */
    @FindBy(how = How.XPATH, using = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']")
    private ElementsCollection scrollHeaders2;

    public ProfilePage profileButtonClick() {
        profileButton.click();
        return page(ProfilePage.class);
    }

    public LoginPage loginButtonClick() {
        loginButton.click();
        return page(LoginPage.class);
    }

    public Boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.shouldBe(Condition.exist, Condition.visible).isDisplayed();
    }

    public void bunTabClick() { bunTab.click(ClickOptions.usingJavaScript()); }

    public void sauceTabClick() { sauceTab.click(ClickOptions.usingJavaScript()); }

    public void fillingTabClick() { fillingTab.click(ClickOptions.usingJavaScript()); }

    public SelenideElement bunTab() { return bunTab; }

    public SelenideElement saouceTab() { return sauceTab; }

    public SelenideElement fillingTab() { return fillingTab; }

    public ElementsCollection getScrollHeadersList() { return scrollHeaders; }
}
