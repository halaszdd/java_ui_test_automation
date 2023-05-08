package hu.inf.unideb.ta.pageobjects;

import hu.inf.unideb.ta.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends CommonPageObjects{

    @FindBy(className = "communities-icon")
    private WebElement communitiesButton;

    public MainPage(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }

    public void clickCommunities() {
        communitiesButton.click();
    }
}
