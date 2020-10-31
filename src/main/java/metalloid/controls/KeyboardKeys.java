package metalloid.controls;


import com.github.metalloid.webdriver.WebDriverPool;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class KeyboardKeys {
    public static void sendKeysToElement(WebElement element, String text) {
        Actions actions = new Actions(WebDriverPool.get());
        actions.sendKeys(element, text).build().perform();
    }

    public static void checkElement() {
        Actions actions = new Actions(WebDriverPool.get());
    }

    public static void arrowDown() {
        Actions actions = new Actions(WebDriverPool.get());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_DOWN).perform();
    }

    public static void arrowUp() {
        Actions actions = new Actions(WebDriverPool.get());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ARROW_UP).perform();
    }

    public static void arrowDownAndUp(int down, int up) {
       for (int x = 0; x < down; x++) {
           arrowDown();
       }

       for (int x = 0; x < up; x++) {
            arrowUp();
        }
    }
}
