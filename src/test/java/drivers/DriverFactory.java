package drivers;

import config.ConfigReader;
import config.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver createDriver() {
        //ChromeOptions options = new ChromeOptions();
        String browser = Environment.browser();

        if (browser == null || browser.isBlank()) {
            throw new RuntimeException("Browser is missing.");
        }

        browser = browser.toLowerCase();
        WebDriver driver;
        System.out.println("Browser = " + browser);
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if(Environment.headless()){
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions fireOptions = new FirefoxOptions();
                if(Environment.headless()){
                    fireOptions.addArguments("--headless");
                }

                driver = new FirefoxDriver(fireOptions);
                break;
                case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if(Environment.headless()){
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);

        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Environment.timeout()));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.get("pageLoadTimeout"))));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.get("scriptTimeout"))));

        return driver;
    }
}
