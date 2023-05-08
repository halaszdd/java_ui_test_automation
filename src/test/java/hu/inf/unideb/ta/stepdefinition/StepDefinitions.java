package hu.inf.unideb.ta.stepdefinition;

import hu.inf.unideb.ta.factory.WebDriverFactory;
import hu.inf.unideb.ta.pageobjects.CommunitiesPage;
import hu.inf.unideb.ta.pageobjects.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

public class StepDefinitions {

    @Autowired
    private WebDriverFactory webDriverFactory;

    @Autowired
    private MainPage mainSite;

    @Autowired
    private CommunitiesPage communitiesPage;

    @Given("the communities portal is opened")
    public void communitiesPortalOpened() {
        webDriverFactory.getWebDriver().get("https://wearecommunity.io/");
    }

    @When("I click the communities button")
    public void iClickTheCommunitiesButton() {
        mainSite.clickCommunities();
    }

    @Then("I click the More Filters button")
    public void iClickTheMoreFiltersButton() {
        communitiesPage.clickOnMoreFiltersButton();
    }

    @And("I click the Language button")
    public void iClickTheLanguageButton() {
        communitiesPage.clickOnLanguageButton();
    }

    @And("I click the Russian check box")
    public void iClickTheRussianCheckBox() {
        communitiesPage.clickOnRussianCheckBox();
    }

    @And("I click the Online switch")
    public void iClickTheOnlineSwitch() {
        communitiesPage.clickOnOnlineSwitch();
    }

    @Then("I type {string} in search")
    public void iTypeInSearch(String searchString) {
        communitiesPage.searchFor(searchString);
    }

    @And("I see the {string} card")
    public void iSeeTheCard(String title) {
        new WebDriverWait(webDriverFactory.getWebDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(communitiesPage.getCard(), title));
    }

    @And("I see {int} card")
    public void iSeeCard(int amount) {
        Assert.assertEquals(amount, communitiesPage.getCardsCountOnPage());
    }
}
