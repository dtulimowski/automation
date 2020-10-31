package pagefactory.linkedin.homepage;

import com.github.metalloid.pagefactory.FindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import pagefactory.PageObject;
import pagefactory.linkedin.dashboard.Dashboard;

public class LoginPage extends PageObject {
    private final String user = System.getProperty("user");
    private final String password = System.getProperty("password");

    @FindBy(css = "input[type='text'")
    private WebElement emailTextField;

    @FindBy(css = "input[type='password'")
    private WebElement passwordTextField;

    @FindBy(css = "button[type='submit']")
    private WebElement signInButton;

    @Step("Dashboard")
    public Dashboard loginAsUser() {
        return loginIntoSystem(user, password);
    }

    @Step("Login as user {0} {1} ")
    public Dashboard loginIntoSystem(String email, String password) {
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
        signInButton.click();
        return new Dashboard();
    }
}
