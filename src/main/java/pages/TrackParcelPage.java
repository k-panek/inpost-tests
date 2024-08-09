package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrackParcelPage extends BasePage {

    public TrackParcelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".track-parcel")
    private WebElement trackParcelPage;

    @FindBy(css = ".tracking-form")
    private WebElement trackingForm;

    @FindBy(css = ".search--mobile--component input")
    private WebElement searchParcelNumberInput;

    @FindBy(css = "[class = \"col-md-3 col-lg-2\"] button[type=\"submit\"]")
    private WebElement findParcelButton;

    @FindBy(css = "[class = \"parcel--statuses--list singleParcelStatusesList -ready\"]")
    private WebElement parcelStatuesList;

    @FindBy(css = "[class=\"single--status--block -active\"] [class=\"paragraph--component -big -secondary\"]")
    private WebElement currentParcelStatus;

    public void waitUntilPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(trackParcelPage));
        wait.until(ExpectedConditions.visibilityOf(trackingForm));
    }

    public void enterParcelNumber(final String parcelNumber) {
        searchParcelNumberInput.sendKeys(parcelNumber);
    }

    public void clickFindParcel() {
        findParcelButton.click();
    }

    public void waitUntilParcelStatusesListIsReturned() {
        wait.until(ExpectedConditions.visibilityOf(parcelStatuesList));
        Actions actions = new Actions(driver);
        actions.scrollToElement(parcelStatuesList).perform();
    }

    public void checkCurrentParcelStatus(final String expectedStatus) {
        Assertions.assertThat(currentParcelStatus.getText())
                .as("Package's status is different than expected")
                .isEqualTo(expectedStatus);
    }
}
