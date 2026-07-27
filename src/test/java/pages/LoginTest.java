package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.LoginPage;
import utils.JsonUtils;
import utils.User;

public class LoginTest extends BaseTest {
    @Test
    public void LoginFail(){
        LoginPage loginPage = new LoginPage(driver);
        User user = JsonUtils.getUser("invalidUser");
        loginPage.openUrl("https://automationexercise.com/");
        loginPage.navigateToLoginPage();
        loginPage.loginAs(user.getUsername(), user.getPassword());
//        loginPage.loginAs(
//                "hphuong2605@gmail.com",
//                "123"
//        );
        Assert.assertEquals( loginPage.getErrorMessage(),"Your email or password is incorrect!");
    }
    @Test
    public void loginSuccess(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openUrl("https://automationexercise.com/");
        User user = JsonUtils.getUser("validUser");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        loginPage.navigateToLoginPage();
        //loginPage.loginAs("hphuong2605@gmail.com", "12345678");
        loginPage.loginAs(user.getUsername(), user.getPassword());
        System.out.println(loginPage.getLoggedInUser());
        Assert.assertTrue(
                loginPage.getLoggedInUser().contains("Logged in as"),
                "Logged in user is incorrect.");
        Assert.assertEquals(
                loginPage.getLoggedInUser(), loginPage.getLoggedInUser(),
                "Logged in user is incorrect.");
    }
}
