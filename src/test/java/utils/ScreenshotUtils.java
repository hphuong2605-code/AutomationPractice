package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
    public static void capture(WebDriver driver, String fileName) {
        try {
        File folder = new File("reports/screenshots/");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("reports/screenshots/" + fileName + ".png");
        FileUtils.copyFile(src,dest);
        Log.logger.info("Screenshot saved: " + dest.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
            Log.logger.error("Cannot save screenshot", e);
        }
    }
}
