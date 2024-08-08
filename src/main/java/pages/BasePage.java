package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriverWait wait;
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(css = "#onetrust-policy-text")
    private WebElement oneTrustPolicyText;

    @FindBy(css = "button#onetrust-accept-btn-handler")
    private WebElement acceptTrustPolicyButton;

    public void acceptTrustPolicyIfNeeded() {
        if (oneTrustPolicyText.isDisplayed()) {
            acceptTrustPolicyButton.click();
            wait.until(ExpectedConditions.invisibilityOf(oneTrustPolicyText));
        }
    }
}
