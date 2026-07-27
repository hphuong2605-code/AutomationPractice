package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final By productNames = By.cssSelector(".cart_description a");
    private final By checkout = By.cssSelector(".check_out");
    private final By deleteButton = By.cssSelector(".cart_quantity_delete");
    private final By emptyCart =
            By.xpath("//b[contains(text(),'Cart is empty')]");

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
    public void removeProduct(){
        while (!driver.findElements(deleteButton).isEmpty()) {
            click(deleteButton);
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(deleteButton,
                    driver.findElements(deleteButton).size()));
        }
    }
    public boolean isEmptyCart() {
        return getText(emptyCart).contains("Cart is empty");
    }
}
