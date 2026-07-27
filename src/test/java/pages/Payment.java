package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Log;

public class Payment extends BasePage {
    private final By name = By.name("name_on_card");
    private final By card = By.name("card_number");

    private final By cvc = By.name("cvc");

    private final By month = By.name("expiry_month");

    private final By year = By.name("expiry_year");

    private final By submit = By.id("submit");
    private final By success = By.xpath("//b[text()='Order Placed!']");

    public Payment(WebDriver driver) {
        super(driver);
    }

    public void payment() {
        Log.logger.info("===== PAYMENT =====");
        type(name, "lucy");
        type(card, "1234123412341234");
        type(cvc, "123");
        type(month, "12");
        type(year, "2030");
        WebElement btn = find(submit);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();
        Log.logger.info("Payment completed");
    }

    public String getSuccessMessage() {
        return getText(success);
    }
}
