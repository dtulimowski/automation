package io.jobee.pagefactory.linkedin.dashboard;

import com.github.metalloid.pagefactory.FindBy;
import com.github.metalloid.webdriver.utils.Inject;
import com.github.metalloid.webdriver.utils.Wait;
import org.openqa.selenium.WebElement;
import io.jobee.pagefactory.PageObject;

import java.util.List;

public class Past24Hours extends PageObject {
    @Inject
    private Wait wait;

    @FindBy(css = ".artdeco-entity-lockup")
    private List<WebElement> results;

    @FindBy(css = "button[name='filter_pill_apply']")
    private WebElement apply;


    public Past24Hours results(String time) {
        System.out.println("\n\n Results " + results.size());
       /* results.stream()
                .filter(webElement -> webElement.getText().contains(time))
                .findFirst()
                .get()
                .click();*/
        return this;
    }

}
