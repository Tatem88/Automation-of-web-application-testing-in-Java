package Lesson1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AuthorizationTest {
    static WebDriver driver;
    String login = "mariq";
    String password = "17e236b32d";
    private static WebDriverWait wait;

    @BeforeEach
    void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // режим полного экрана
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void test() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        Thread.sleep(2000L);
        driver.quit();
    }

    @Test
    void authorizationTest() throws InterruptedException {
        WebElement loginNew = driver.findElement(By.xpath("//*[@type='text']"));
        WebElement passwordNew = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement buttonNew = driver.findElement(By.xpath("//*[@class='mdc-button__label']"));


        loginNew.sendKeys(login);
        passwordNew.sendKeys(password);
        Thread.sleep(2000L);
        buttonNew.click();

        List<WebElement> searchList = driver.findElements(By.partialLinkText("Hello"));
        Assertions.assertEquals(1, searchList.size());
    }

    @AfterEach
    void close() {
        driver.quit();
    }
}

