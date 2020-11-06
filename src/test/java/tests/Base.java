package tests;

import io.qameta.allure.Step;
import io.pagefactory.linkedin.homepage.HomePage;

@TestCore
public class Base {
    @Step("Main page is opening")
    public static HomePage mainPage() {
        return new HomePage();
    }

}