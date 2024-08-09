package drivers;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Getter
public class Driver {
    private WebDriver driver;

    public Driver() {
        setDriver();
    }

    private void setDriver() {
        String gridUrl = System.getProperty("grid");

        if (gridUrl == null) {
            driver = new ChromeDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            URL url;
            try {
                url = new URL(gridUrl);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver = new RemoteWebDriver(url, options);
        }
    }

}
