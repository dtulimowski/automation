package io.jobee.controls;

import com.github.metalloid.webdriver.WebDriverPool;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class CookieHandler {

    public static Set<Cookie> getAllCookies() {
        return WebDriverPool.get().manage().getCookies();
    }

    public static void restoreAllCookies(Set<Cookie> allCookies) {
        if(allCookies != null){
            allCookies.forEach(cookie -> WebDriverPool.get().manage().addCookie(cookie));
            System.out.println("\nCookies loaded\n");
        }else {
            System.out.println("\nCookies not loaded\n");
        }

    }
}
