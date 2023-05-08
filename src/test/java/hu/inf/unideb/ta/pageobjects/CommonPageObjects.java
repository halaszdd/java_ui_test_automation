package hu.inf.unideb.ta.pageobjects;

import hu.inf.unideb.ta.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPageObjects {

    protected WebDriver driver;

    public CommonPageObjects(WebDriverFactory webDriverFactory) {
        this.driver = webDriverFactory.getWebDriver();
        PageFactory.initElements(driver,this);
    }
}
