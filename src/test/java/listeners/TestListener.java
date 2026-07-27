package listeners;

import base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Log;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        Log.logger.info("===== START TEST SUITE" + context.getName() + "=====");
    }

    @Override
    public void onFinish(ITestContext context) {
        Log.logger.info("===== FINISH TEST SUITE: " + context.getName() + "=====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.logger.info("START TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.logger.info("PASS: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.logger.error("FAIL: " + result.getName());
        if (BaseTest.getDriver() != null) {
            ScreenshotUtils.capture(BaseTest.getDriver(), result.getName());
        }
        if (result.getThrowable() != null) {
            Log.logger.error(result.getThrowable().getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.logger.warn("SKIPPED: " + result.getName());
    }
}
