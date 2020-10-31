package metalloid.controls;

import com.github.metalloid.pagefactory.controls.Control;
import com.github.metalloid.webdriver.utils.Inject;
import com.github.metalloid.webdriver.utils.JavaScript;
import com.github.metalloid.webdriver.utils.UtilsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddNewServicesRows extends Control {
    @Inject
    private JavaScript javaScript;

    private List<WebElement> elementsDIVs;

    public AddNewServicesRows(WebDriver driver, SearchContext searchContext, By locator) {
        super(driver, searchContext, locator);
        UtilsFactory.initUtilities(driver, this);
    }

    public AddNewServicesRows(WebDriver driver, SearchContext searchContext, By locator, Integer index) {
        super(driver, searchContext, locator, index);
        UtilsFactory.initUtilities(driver, this);
    }

    public String getDayName() {
        return getDIVs().get(0).getText();
    }

    public AddNewServicesRows from(String from) {
        getDIVs().get(2).findElement(By.cssSelector("input[placeholder='From']")).sendKeys(from);
        return this;
    }


    private List<WebElement> getDIVs() {
        if(elementsDIVs != null) {
            return elementsDIVs;
        } else {
           return this.elementsDIVs = super.element().findElements(By.tagName("div"));
        }
    }

}
