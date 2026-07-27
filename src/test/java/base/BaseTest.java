package base;

import config.Environment;
import drivers.DriverFactory;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(listeners.TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected static WebDriver currentDriver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        currentDriver = driver;
        driver.get(Environment.baseUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return currentDriver;
    }
}
