package Lesson1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class DummyTest extends AuthorizationTest{
    WebDriverWait wait;

    @Test
    @DisplayName("Creation")
    void createDummyInPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement loginNew = driver.findElement(By.xpath("//*[@type='text']"));
        WebElement passwordNew = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement buttonNew = driver.findElement(By.xpath("//*[@class='mdc-button__label']"));
        loginNew.sendKeys(login);
        passwordNew.sendKeys(password);
        Thread.sleep(2000L);
        buttonNew.click();
        WebElement buttonCreate = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.id("create-btn")));
        buttonCreate.click();
        WebElement titleNew = driver.findElement(By.xpath("//*[@type='text']"));
        titleNew.sendKeys("DummyTest");
        Thread.sleep(2000L);
        WebElement descriptionNew = driver.findElement(By.xpath("//*[@id=\"create-item\"]/div/div/div[2]/div/label"));
        descriptionNew.sendKeys("test test test test test test");
        WebElement contentNew = driver.findElement(By.xpath("//*[@id=\"create-item\"]/div/div/div[3]/div/label/span/textarea"));
        contentNew.sendKeys("Hi!");
        WebElement buttonPage = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@type='submit']")));
        buttonPage.click();
        List<WebElement> elementsDummy = driver.findElements(By.xpath("//h1[@class='svelte-tv8alb']"));
        Assertions.assertEquals("DummyTest",elementsDummy.get(0).getText());
        Thread.sleep(2000L);

    }
}

