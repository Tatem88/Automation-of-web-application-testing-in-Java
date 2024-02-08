import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BaseTest {

    private static String username = "mariq";
    private static String password = "17e236b32d";


    public static String getLogin() {
        return username;
    }

    public static String getPassword() {
        return password;
    }


    @AfterAll
    static void tearDown() {
        Selenide.closeWebDriver();
    }

    @BeforeAll
    static void SetUp() {



     Configuration.remote = "http://localhost:4444/wd/hub";
  //    Configuration.remote = "http://192.168.1.69:4444/wd/hub";
 //     Configuration.reportsFolder = "target/surefire-reports";
 //     Configuration.downloadsFolder = "target/downloads";

        Selenide.open("https://test-stand.gb.ru/login");
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.pageLoadTimeout = 5000;
    }



}
