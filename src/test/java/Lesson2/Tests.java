package Lesson2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tests extends BaseTest {

    @Test
    void checkAuthFailed() {
        driver.get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.CheckAuthFailed();
        WebElement checkElement = driver.findElement
                (By.xpath("//h2[text()='401']"));
        Assertions.assertEquals("401", checkElement.getText());
    }

    @Test
    void checkEditName() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.CheckAuthSuc(getUsername(), getPassword());

        EditPage editPage = new EditPage(driver);
        editPage.editCard("TestCard");

        WebElement searchElement = driver.
                findElement(By.xpath("//h1[text()='TestCard']"));
        Assertions.assertEquals("TestCard", searchElement.getText());
    }

    @Test
    void checkModalWindow() throws InterruptedException {
        driver.get("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.CheckAuthSuc(getUsername(), getPassword());
        EditPage editPage = new EditPage(driver);
        editPage.editCard("TestCard");
        editPage.openPost();
        WebElement webElement = driver.findElement(By.cssSelector("tbody tr td"));
        Assertions.assertEquals("96870", webElement.getText());
    }

}