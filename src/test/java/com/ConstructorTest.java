package com;

import com.pages.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest extends BaseTest {

    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    public void bunTabTest() {
        mainPage.bunTabClick();
        mainPage.bunTab().shouldHave(attributeMatching("class", ".*current.*"));
    }

    @Test
    public void sauceTabTest() {
        mainPage.sauceTabClick();
        mainPage.saouceTab().shouldHave(attributeMatching("class", ".*current.*"));
    }

    @Test
    public void fillingTabTest() {
        mainPage.fillingTabClick();
        mainPage.fillingTab().shouldHave(attributeMatching("class", ".*current.*"));
    }
}
