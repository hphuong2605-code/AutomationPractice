package utils;

import org.openqa.selenium.json.Json;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {JsonUtils.getUser("validUser")},
                {JsonUtils.getUser("invalidUser")},
                {JsonUtils.getUser("lockedUser")}
        };
    }
}
