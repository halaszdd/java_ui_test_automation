package hu.inf.unideb.ta.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.util.Objects;

public class WebDriverFactory {
    private WebDriver webDriver;

    @Value("${width:1920}")
    private int width;

    @Value("${height:1080}")
    private int height;

    @Value("${headless:false}")
    private Boolean headless;

    private WebDriver setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver chrome = new ChromeDriver(new ChromeOptions()
                .addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .setHeadless(headless));
        chrome.manage().window().setSize(new Dimension(width, height));
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return chrome;
    }

    public WebDriver getWebDriver() {
        if (Objects.isNull(webDriver)) {
            webDriver = setupWebDriver();
        }
        return webDriver;
    }

    public void tearDown() {
        if (Objects.nonNull(webDriver)) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
