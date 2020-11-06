package io.selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.metalloid.webdriver.WebDriverPool;
import io.other.UrlMaker;
import io.reports.Report;
import io.reports.Standard;
import org.junit.jupiter.api.extension.*;

import java.util.Arrays;
import java.util.Optional;

public class Preconditions implements BeforeAllCallback, AfterAllCallback, TestWatcher, BeforeTestExecutionCallback {
    public ExtentTest test;
    private ExtentReports report;
    private final String path = UrlMaker.make("io/reports", "html");

    @Override
    public void beforeAll(ExtensionContext context){
        report = Report.open(path, new Standard());
        DriverManager.getBrowserDriver();
        WebDriverPool.get();
    }

    @Override
    public void afterAll(ExtensionContext context) {
        report.flush();
        System.out.println("\nreport saved: " + path);
        WebDriverPool.closeSession(Thread.currentThread());
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        test = report.createTest(context.getDisplayName());
        test.assignAuthor(System.getProperty("user.name"));
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        test.warning(Arrays.toString(cause.getStackTrace()));
        test.assignCategory("Aborted");
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        test.skip(context.getTags().toString());
        test.assignCategory("Disabled");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        test.fail(cause);
        test.assignCategory("Failed");
        Screenshot.takeScreenshot(context.getTestMethod().get().getName(), cause);
        test.addScreenCaptureFromPath(Screenshot.getScreenshot(), "Failed");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        test.pass(context.getTags().toString());
        test.assignCategory("Passed");
    }
}
