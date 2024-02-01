package Lesson2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
