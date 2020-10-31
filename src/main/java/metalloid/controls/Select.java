package metalloid.controls;

import com.github.metalloid.pagefactory.controls.Control;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Select extends Control {

    public Select(WebDriver driver, SearchContext searchContext, By locator) {
        super(driver, searchContext, locator);
    }

    public Select(WebDriver driver, SearchContext searchContext, By locator, Integer index) {
        super(driver, searchContext, locator, index);
    }

    public void selectElementByName(String name) {
        getSelect().selectByVisibleText(name);
    }

    public void selectElementValue(String value) {
        getSelect().selectByValue(value);
    }

    private org.openqa.selenium.support.ui.Select getSelect() {
        return new org.openqa.selenium.support.ui.Select(super.element());
    }
}
