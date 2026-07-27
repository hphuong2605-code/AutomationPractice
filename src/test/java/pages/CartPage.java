package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final By productNames = By.cssSelector(".cart_description a");
    private final By checkout = By.cssSelector(".check_out");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement e : driver.findElements(productNames)){
            names.add(e.getText().replaceAll("\\s+", " ").trim());
        }
        return  names;
    }
    public void checkout(){
        click(checkout);
    }
}
