package reports;

import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Standard implements Config {
    @Override
    public ExtentSparkReporterConfig get() {
        return ExtentSparkReporterConfig.builder()
                .reportName(System.getProperty("user.name"))
                .documentTitle("Job seeker")
                .theme(Theme.STANDARD)
                .timelineEnabled(true)
                .build();
    }
}
