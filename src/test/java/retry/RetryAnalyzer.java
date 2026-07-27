package retry;

import config.ConfigReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.Log;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    //private int maxRetry = 2;
    private final int maxRetry = Integer.parseInt(ConfigReader.get("retry"));

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetry) {
            retryCount++;
            Log.logger.warn("Retry" + retryCount + "/" + maxRetry +"for test: " + result.getName());
            return true;
        }
        return false;
    }
}
