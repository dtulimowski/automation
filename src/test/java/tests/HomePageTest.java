package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import other.InGen;
import pagefactory.Base;
import selenium.groups.Regression;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
public class HomePageTest extends Base {

    @Autowired
    InGen inGen;

    @Regression
    @Tag("TwentyFourHours")
    @DisplayName("Spring test running")
    public void SpringTest() {
        assertEquals("darek",  inGen.getName());
    }

    //@Regression
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
        assertEquals("darek",  inGen.getName());
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
