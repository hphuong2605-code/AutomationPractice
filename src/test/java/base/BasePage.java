package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openUrl(String url) {
        Log.logger.info("Open URL: " + url);
        driver.get(url);
    }

    public void click(By locator) {
        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
        Log.logger.info("Click: " + locator);
    }

    public void type(By locator, String text) {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();
        element.sendKeys(text);
        String locatorText = locator.toString().toLowerCase();

        if (locatorText.contains("password")) {
            Log.logger.info("Type password: ******");
        } else {
            Log.logger.info("Type: " + text);
        }
    }

    public String getText(By locator) {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
    }

    public boolean isDisplayed(By locator) {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator))
                .isDisplayed();
    }

    public WebElement find(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> finds(By locator) {
        return driver.findElements(locator);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
