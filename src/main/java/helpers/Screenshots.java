package helpers;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshots {
    public static void takeScreenshot(final WebDriver driver, final Scenario s) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(
                    String.format("./target/screenshots/%s-%s.png", s.getName(), s.getId())));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
}
