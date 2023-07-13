package ru.aptekaeconom.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class WebTest {

    @BeforeAll
    public static void setDriver() throws MalformedURLException {
        Configuration.timeout = 6000;
        Configuration.browser = "chrome";

        ChromeOptions options = new ChromeOptions();
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(), options
        );
        setWebDriver(remoteWebDriver);
        //onfiguration.browser = "chrome";

    }
}
