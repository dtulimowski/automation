package selenium;

import com.github.metalloid.webdriver.WebDriverPool;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class Screenshot {
    private static final Logger logger = LogManager.getLogger(Screenshot.class);
    private static File screenshot;
    private static LocalTime timestamp = LocalTime.now();

    public static void takeScreenshot(String method, Throwable e) {
        WebDriver driver = WebDriverPool.get();
        if(driver instanceof TakesScreenshot){
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
            try {
                File localScreenshots = new File(("target"), "screenshots");
                if (!localScreenshots.isFile() || !localScreenshots.isDirectory()) {
                    localScreenshots.mkdirs();
                }
                screenshot = new File(localScreenshots,method + "_" + timestamp.getHour() + ":" + timestamp.getMinute() + ":" + timestamp.getSecond() + ".png");
                try {
                    FileUtils.moveFile(takesScreenshot.getScreenshotAs(OutputType.FILE), screenshot);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                logger.info("Screenshot for method={} saved in: {}" + method + " " + screenshot.getAbsolutePath());
            } catch (Exception e1){
                logger.error("Unable to take screenshot"+ e1);
            }
        }else{
            logger.info("Driver '{}' can't take screenshots so skipping it." + driver.getClass() + e);
        }
    }

    //@Attachment()
    public static String getScreenshot() {
        logger.info("Get screenshot" + screenshot.getName());
        Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) WebDriverPool.get()).getScreenshotAs(OutputType.BYTES)));
        return screenshot.getAbsolutePath();
    }

}
