package hu.inf.unideb.ta.pageobjects;

import hu.inf.unideb.ta.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommunitiesPage extends CommonPageObjects{

    @FindBy(css = ".evnt-search-filter .evnt-text-fields")
    private WebElement searchField;

    @FindBy(className = "evnt-toogle-filters-text")
    private WebElement moreFiltersButton;

    @FindBy(css = "#filter_language > span")
    private WebElement languageButton;

    @FindBy(css = "#collapseMoreFilters > div > div > div:nth-child(1) > div > div.evnt-filter-menu.evnt-dropdown-menu.dropdown-menu.with-arrow.show > div.evnt-filter-menu-scroll > div:nth-child(2) > div:nth-child(4) > div > label")
    private WebElement russianCheckBox;

    @FindBy(css = "#collapseMoreFilters > div > div > div:nth-child(2) > div > div > label")
    private WebElement onlineSwitch;

    @FindBy(css = ".evnt-communities-row .evnt-communities-column .evnt-name-wrapper")
    private WebElement card;

    @FindBy(css = ".evnt-communities-row .evnt-communities-column")
    private List<WebElement> cards;

    public CommunitiesPage(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }


    public void clickOnMoreFiltersButton() {
        moreFiltersButton.click();
    }

    public void clickOnLanguageButton() {
        languageButton.click();
    }

    public void clickOnRussianCheckBox() {
        russianCheckBox.click();
    }

    public void clickOnOnlineSwitch() {
        onlineSwitch.click();
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public int getCardsCountOnPage() {
        return cards.size();
    }

    public WebElement getCard() {
        return card;
    }
}
