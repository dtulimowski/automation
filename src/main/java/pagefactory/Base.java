package pagefactory;

import annotations.TestCore;
import io.qameta.allure.Step;
import pagefactory.linkedin.homepage.HomePage;

@TestCore
public class Base {
    @Step("Main page is opening")
    public static HomePage mainPage() {
        return new HomePage();
    }

}
