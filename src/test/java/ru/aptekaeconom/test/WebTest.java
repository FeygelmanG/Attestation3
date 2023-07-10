package ru.aptekaeconom.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Objects;

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
        Configuration.browser = "chrome";

    }
//        String isRemote = System.getenv("IS_REMOTE");
//        if (Objects.equals(isRemote, "true")) {
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.setCapability("enableVNC:", true);
//            WebDriver driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), chromeOptions);
//            setWebDriver(driver);
//        } else {
//            Configuration.browser = "chrome";
//        }
//    }
//        boolean isRemote = true;
//        if (isRemote == true) {
//            Configuration.timeout = 6000;
//            Configuration.browser = "chrome";
//
//            ChromeOptions options = new ChromeOptions();
//            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(
//                    URI.create("http://localhost:4444/wd/hub").toURL(), options
//            );
//            setWebDriver(remoteWebDriver);
//        } else {
//            Configuration.browser = "chrome";
//        }
    //}
}
