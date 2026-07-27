package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Log;

public class ProductPage extends BasePage {
//    private final By firstAddToCart = By.xpath("(//a[contains(@class,'btn btn-default')])[2]']");
//    private final By continueShopping = By.xpath("(//ul[contains(@class,'nav nav-pills')]//a)[9]");
//    private final By viewCart = By.xpath("//a[@href='/product/']");

    private final By productCart = By.cssSelector(".product-image-wrapper");
    private final By btnContinueShopping = By.xpath("(//button[text()='Continue Shopping'])");
    private final By viewCart =
            By.xpath("//u[text()='View Cart']");
    private final By textSearch = By.id("search_product");
    private final By btnSearch = By.id("submit_search");
    private final By searchTitle = By.xpath("//h2[text()='Searched Products']");
    private final By productNames =
            By.cssSelector(".productinfo p");
    private final By productsMenu =
            By.xpath("//a[@href='/products']");

    public List<String> addFirstTwoProducts() {
        List<String> productNames = new ArrayList<>();
        List<WebElement> products = driver.findElements(productCart);
        for (int i = 0; i < 2; i++) {
            WebElement product = products.get(i);
            Log.logger.info("===== ADD PRODUCTS =====");
            String name = product.findElement(By.tagName("p")).getText().replaceAll("\\s+", " ").trim();
            Log.logger.info("Adding product: " + name);
            productNames.add(name);

            // Hover over to show Add to Cart
            Actions actions = new Actions(driver);
            actions.moveToElement(product).perform();

            WebElement addBtn =
                    product.findElement(By.xpath(".//a[contains(@class,'add-to-cart')]"));
            wait.until(ExpectedConditions.elementToBeClickable(addBtn));

            //Add to Cart
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", addBtn);
            Log.logger.info("Added: " + name);

            if (i==0){
                click(btnContinueShopping);
            }
        }

        return productNames;
    }
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void viewCart() {
        click(viewCart);
    }
    public void search(String keyword){
        type(textSearch,keyword);
        click(btnSearch);
    }
    public boolean isSearchDisplayed() {
        return isDisplayed(searchTitle);
    }

    public boolean hasProduct(String productName) {
        List<WebElement> products = finds(productNames);

        for (WebElement product : products) {
            if (product.getText().trim().equals(productName)) {
                return true;
            }
        }

        return false;
    }
    public void goToProducts() {
        click(productsMenu);
    }
}
