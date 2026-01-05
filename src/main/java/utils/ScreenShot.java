package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
            File target = new File(path);

            FileUtils.copyFile(source, target);

            System.out.println("Screenshot saved at: " + path);
        } 
        catch (IOException e) {
            System.out.println("❌ Screenshot capture failed: " + e.getMessage());
        }
    }
}
