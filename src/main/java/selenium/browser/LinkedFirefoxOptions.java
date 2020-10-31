package selenium.browser;

import com.github.metalloid.webdriver.Options;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class LinkedFirefoxOptions implements Options<FirefoxOptions> {
    private final static boolean headless = System.getProperty("headless").contains("true");

    public FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(headless);
        options.addArguments("--start-fullscreen");
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT);
        return options;
    }
}
