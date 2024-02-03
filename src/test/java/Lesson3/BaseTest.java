package Lesson3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static String username = "mariq";
    private static String password = "17e236b32d";

    public static String getUsername() {
        return username;
    }
    public static String getPassword() {
        return password;
    }

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
        Configuration.headless = true;
        Configuration.timeout = 5000;
        Configuration.browser = "chrome";
    }
    @AfterAll
    static void tearDown() {
        Selenide.closeWebDriver();
    }
}
