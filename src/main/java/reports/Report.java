package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
    public static ExtentReports open(String reportPath, Config config) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config(config.get());
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }

}
