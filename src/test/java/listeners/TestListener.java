package listeners;
import base.BaseTest;
import utility.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println(
                "STARTED: " +
                        result.getName()
        );
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println(
                "PASSED: " +
                        result.getName()
        );
    }

    @Override
    public void onTestFailure(
            ITestResult result)
    {
        System.out.println(
                "FAILED: " +
                        result.getName()
        );

        BaseTest test =
                (BaseTest) result
                        .getInstance();

        ScreenshotUtil.captureScreenshot(
                test.getDriver(),
                result.getName()
        );
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println(
                "SKIPPED: " +
                        result.getName()
        );
    }
}