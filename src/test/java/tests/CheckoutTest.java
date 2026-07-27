package tests;

import base.BaseTest;
import config.Environment;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import retry.RetryAnalyzer;
import utils.JsonUtils;
import utils.User;

import java.util.List;

public class CheckoutTest extends BaseTest {
    @Test(
            retryAnalyzer = RetryAnalyzer.class
    )
    public void checkoutSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Payment paymentPage = new Payment(driver);
        User user = JsonUtils.getUser("validUser");

        loginPage.openUrl(Environment.baseUrl());
        loginPage.navigateToLoginPage();
        loginPage.loginAs(user.getUsername(), user.getPassword());
        Assert.assertTrue(loginPage.isLoggedIn());
        //homePage.openUrl(Environment.baseUrl());

        List<String> expected = productPage.addFirstTwoProducts();
        productPage.viewCart();
        List<String> actual = cartPage.getProductNames();
//        for (WebElement e : driver.findElements(productNames)) {
//            names.add(e.getText().trim());
//        }
        Assert.assertEquals(actual, expected);
        cartPage.checkout();
        checkoutPage.placeOrder();
        paymentPage.payment();
        //Assert.assertEquals(paymentPage.getSuccessMessage(),"ORDER PLACED!");
        Assert.assertEquals(paymentPage.getSuccessMessage(),"ABC");
    }
}
