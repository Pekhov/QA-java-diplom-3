package com;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    BaseTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "chrome";
        //Yandex browser
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pekhov\\Downloads\\yandexdriver\\yandexdriver.exe");
    }
}
