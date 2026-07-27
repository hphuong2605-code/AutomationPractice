package tests;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginMenu =
            By.xpath("//a[normalize-space()='Signup / Login']");
    private final By email =
            By.xpath(" //input[@data-qa='login-email']");

    private final By password =
            By.xpath("//input[@placeholder='Password']");

    private final By loginButton =
            By.xpath("//button[normalize-space()='Login']");

    private final By errorMessage =
            By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    private final By lblLoggedInUser =
            By.xpath("//a[contains(.,'Logged in as')]");

    public void navigateToLoginPage() {
        click(loginMenu);
    }

    public boolean isLoggedIn() {
        return isDisplayed(lblLoggedInUser);
    }

    public void loginAs(String user, String pass) {
        Log.logger.info("===== LOGIN =====");
        type(email, user);
        type(password, pass);
        click(loginButton);
        Log.logger.info("Login submitted");
    }

    public String getLoggedInUser() {
        waitForVisible(lblLoggedInUser);
        return getText(lblLoggedInUser);
    }
    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
