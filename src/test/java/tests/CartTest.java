package tests;

import base.BaseTest;
import config.Environment;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.JsonUtils;
import utils.User;

public class CartTest extends BaseTest {
    @Test
    public void removeProduct(){
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        User user = JsonUtils.getUser("validUser");

        login.openUrl(Environment.baseUrl());
        login.navigateToLoginPage();
        login.loginAs(user.getUsername(), user.getPassword());
        home.openUrl(Environment.baseUrl());
        product.addFirstTwoProducts();
        product.viewCart();
        cart.removeProduct();
        Assert.assertTrue(cart.isEmptyCart());
    }
}
