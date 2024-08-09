package stepsdefinitions;

import drivers.Driver;
import helpers.Screenshots;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.TrackParcelPage;

public class GuiSteps extends Base {
    protected WebDriver driver;
    protected String basePage;

    @Before(value = "@GuiTests")
    public void setup() {
        driver = new Driver().getDriver();
        driver.manage().window().maximize();
        basePage = properties.getProperty("basePage");
        driver.get(basePage);
    }

    @After(value = "@GuiTests")
    public void quitDriver(Scenario s) {
        if (s.isFailed()) {
            Screenshots.takeScreenshot(driver, s);
        }
        driver.quit();
    }

    @Given("user is on track shipment page")
    public void user_is_on_track_shipment_page() {
        this.driver.get(basePage + "/sledzenie-przesylek");
        TrackParcelPage trackParcelPage = new TrackParcelPage(driver);
        trackParcelPage.acceptTrustPolicyIfNeeded();
        trackParcelPage.waitUntilPageIsLoaded();
    }

    @When("user enters parcel number {string}")
    public void user_enters_parcel_number(final String parcelNumber) {
        TrackParcelPage trackParcelPage = new TrackParcelPage(driver);
        trackParcelPage.enterParcelNumber(parcelNumber);
    }

    @And("user clicks find button")
    public void user_clicks_find_button() {
        TrackParcelPage trackParcelPage = new TrackParcelPage(driver);
        trackParcelPage.clickFindParcel();
    }

    @Then("list of parcel statuses is displayed")
    public void list_of_parcel_statuses_is_displayed() {
        TrackParcelPage trackParcelPage = new TrackParcelPage(driver);
        trackParcelPage.waitUntilParcelStatusesListIsReturned();
    }

    @And("the last parcel status is {string}")
    public void the_last_parcel_status_is(final String expectedStatus) {
        TrackParcelPage trackParcelPage = new TrackParcelPage(driver);
        trackParcelPage.checkCurrentParcelStatus(expectedStatus);
    }
}
