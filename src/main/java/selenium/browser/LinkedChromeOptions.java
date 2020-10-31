package selenium.browser;

import com.github.metalloid.webdriver.Options;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class LinkedChromeOptions implements Options<ChromeOptions> {
   private final static boolean headless = System.getProperty("headless").contains("true");

    public ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(headless);
        options.addArguments("--start-fullscreen");
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        return options;
    }
}
