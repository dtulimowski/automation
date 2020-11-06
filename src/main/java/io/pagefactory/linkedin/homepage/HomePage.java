package io.pagefactory.linkedin.homepage;

import com.github.metalloid.name.Name;
import com.github.metalloid.pagefactory.FindBy;
import com.github.metalloid.webdriver.WebDriverPool;
import com.github.metalloid.webdriver.utils.Inject;
import com.github.metalloid.webdriver.utils.JavaScript;
import com.github.metalloid.webdriver.utils.Wait;
import io.pagefactory.PageObject;
import io.qameta.allure.Step;
import io.controls.KeyboardKeys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {
    @Inject
    private Wait wait;

    @Inject
    private JavaScript javaScript;

    private final String env = System.getProperty("environment");

    @Step("Open url:")
    public HomePage openUrl() {
        WebDriverPool.get().get(env);
        return this;
    }

    @FindBy(css = "a[class*='nav__button-secondary']")
    private WebElement signInButton;

    @FindBy(textEquals = "Find jobs, people, and more")
    private WebElement expandSearch;

    @FindBy(css = "form[id='JOBS'] input[aria-label='Search job titles or companies']")
    private WebElement search;

    @Name(description = "location")
    @FindBy(css = "form[id='JOBS'] input[name='location']")
    private WebElement location;

    @Name(description = "submit button")
    @FindBy(css ="button[form='JOBS']")
    private WebElement submit;

    @Step("SignIn")
    public LoginPage signIn() {
        signInButton.click();
        return new LoginPage();
    }

    public void expandSearch() {
        try {
            wait.until(4, ExpectedConditions.visibilityOf(expandSearch));
        } catch (TimeoutException e) {
            System.out.println("\nNo searchBar found\n");
        }
    }

    public HomePage search(String text) {
        expandSearch();
        KeyboardKeys.sendKeysToElement(search, text);
        return this;
    }

    public HomePage location(String text) {
        wait.until(4, ExpectedConditions.visibilityOf(location));
        location.clear();
        KeyboardKeys.sendKeysToElement(location, text);
        return this;
    }

    public HomePage submit() {
        wait.until(4, ExpectedConditions.visibilityOf(submit));
        javaScript.click(submit);
        return this;
    }

}
