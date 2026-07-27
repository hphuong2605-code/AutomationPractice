package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By productMenu = By.xpath("//a[@href='/product/']");
    public void goToProducts(){
        click(productMenu);
    }
}
