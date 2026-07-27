package pages;

import base.BaseTest;
import config.Environment;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void searchProduct() {
        ProductPage product = new ProductPage(driver);

        product.openUrl(Environment.baseUrl());
        product.goToProducts();
        product.search("Blue Top");
        Assert.assertTrue(product.isSearchDisplayed());
        Assert.assertTrue(product.hasProduct("Blue Top"));
    }
}
