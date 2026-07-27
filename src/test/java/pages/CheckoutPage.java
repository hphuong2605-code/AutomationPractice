package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class CheckoutPage extends BasePage {
    private final By comment = By.name("message");
    private final By placeOrder = By.xpath("//a[text()='Place Order']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public void placeOrder(){
        Log.logger.info("===== CHECKOUT =====");
        type(comment,"Automation Test");
        click(placeOrder);
    }
}
