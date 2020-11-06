package io.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    public static void getBrowserDriver() {
        String browserName = System.getProperty("browser.name");
            switch(browserName) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    System.setProperty("webdriver.gecko.driver", WebDriverManager.firefoxdriver().getDownloadedDriverPath());
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    System.setProperty("webdriver.chrome.driver", WebDriverManager.chromedriver().getDownloadedDriverPath());
                    break;
                default:
                    System.out.println("\n DriverManager: Browser is not implemented\n");
            }
    }
}
