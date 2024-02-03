package Lesson3;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseTest {

    @Test
    void checkAuthFailed() {
        open("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage();
        loginPage.CheckAuthFailed();
        SelenideElement checkElement = $("h2:contains('401')");
        Assertions.assertEquals("401", checkElement.text());
    }

    @Test
    void checkEditName() {
        open("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage();
        loginPage.CheckAuthSuc(getUsername(), getPassword());

        EditPage editPage = new EditPage();
        editPage.editCard("TestCard");

        SelenideElement searchElement = $$("h1").findBy(Condition.text("TestCard"));
        Assertions.assertEquals("TestCard", searchElement.text());
    }

    @Test
    void checkModalWindow() {
        open("https://test-stand.gb.ru/login");
        LoginPage loginPage = new LoginPage();
        loginPage.CheckAuthSuc(getUsername(), getPassword());

        EditPage editPage = new EditPage();
        editPage.editCard("TestCard");
        editPage.openPost();

        SelenideElement webElement = $$("tbody tr td").first();
        Assertions.assertEquals("96870", webElement.text());
    }

}