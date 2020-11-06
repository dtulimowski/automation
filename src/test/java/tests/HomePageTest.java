package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import io.other.InGen;
import io.selenium.groups.Regression;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends Base {

    @Autowired
    private InGen inGen;

    //@Regression
    @DisplayName("Spring first test")
    public void SpringTest() {
        assertEquals("Darek", inGen.getName());
    }

    @Regression
    @Tag("TwentyFourHours")
    @DisplayName("Home Page - logged successfully")
    public void LinkedLogin_01() {
        Base
                .mainPage()
                .openUrl()
                .signIn()
                .loginAsUser()
                .jobs()
                .selectAlert("tester")
                .datePostedTwentyFourHours()
                .datePostedApply()
                .results("");
    }

    //@Regression
    @Tag("PastWeek")
    @DisplayName("Home Page - failed query")
    public void LinkedLogin_02() {
        Base
                .mainPage()
                .openUrl()
                .signIn()
                .loginAsUser()
                .jobs()
                .selectAlert("ble ble ")
                .datePostedPastWeek()
                .datePostedApply()
                .results("");
    }

}
