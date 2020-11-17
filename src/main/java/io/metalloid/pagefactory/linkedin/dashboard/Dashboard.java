package io.pagefactory.linkedin.dashboard;

import com.github.metalloid.pagefactory.FindBy;
import com.github.metalloid.webdriver.utils.Inject;
import com.github.metalloid.webdriver.utils.JavaScript;
import io.pagefactory.PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class Dashboard extends PageObject {
    @Inject
    JavaScript javaScript;

    @FindBy(css ="button[class='secondary-action']")
    private WebElement addPhoneNumberSkip;

    @FindBy(css = "input[placeholder='Search']")
    private WebElement searchFiled;

    @FindBy(css = "button[type='button']")
    private WebElement submit;

    @FindBy(css = "a[data-link-to='jobs']")
    private WebElement jobs;

    public Dashboard addPhoneNumberSkip() {
       addPhoneNumberSkip.click();
       return this;
    }
    @Step("Search statement: {0}")
    public Dashboard search(String statement) {
        searchFiled.sendKeys(statement);
        return this;
    }
    @Step("Submit")
    public Dashboard submit() {
        submit.click();
        return this;
    }

    @Step("Jobs category")
    public Jobs jobs() {
        javaScript.click(jobs);
        return new Jobs();
    }

}
