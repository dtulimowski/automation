package io.jobee.pagefactory.linkedin.dashboard;

import com.github.metalloid.pagefactory.FindBy;
import com.github.metalloid.webdriver.utils.Inject;
import com.github.metalloid.webdriver.utils.Wait;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.jobee.pagefactory.PageObject;

import java.util.List;

public class Jobs extends PageObject {
    @Inject
    private Wait wait;

    @FindBy(css = "input[aria-label='Search by title, skill, or company']")
    private WebElement search;

    @FindBy(css = "input[aria-label='City, state, or zip code']")
    private WebElement location;

    @FindBy(css = "button[type='submit']")
    private WebElement submit;

    @FindBy(css = "button[aria-label='Manage job alerts']")
    private WebElement manageAlerts;

    @FindBy(css = "span[class*='jobs-home-soho-search-card__truncated-text t-14 t-black t-bold']")
    private List<WebElement> results;


    public Jobs search(String statement) {
        search.sendKeys(statement);
        return this;
    }

    public Jobs location(String city) {
        location.sendKeys(city);
        return this;
    }

    public Jobs submit() {
        submit.click();
        return this;
    }

    @Step("Select alert: {0}")
    public Tester selectAlert(String result) {
        wait.until(ExpectedConditions.visibilityOf(manageAlerts));
        results.stream()
                .filter(webElement -> webElement.getText().contains(result))
                .findFirst()
                .get()
                .click();
        return new Tester();
    }

}
