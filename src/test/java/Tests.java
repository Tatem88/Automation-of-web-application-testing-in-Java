import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.hc.core5.http.nio.ssl.BasicServerTlsStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Tests extends BaseTest {



    @Test
    void checkEditName() throws InterruptedException {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.CheckAuthSuc(getLogin(), getPassword());

        EditPage editPage = Selenide.page(EditPage.class);
        editPage.editCard("TestCard");

        SelenideElement searchElement = $x("//h1[text()='TestCard']");
        Assertions.assertEquals("TestCard", searchElement.getText());

    }

    @Test
    void checkModalWindow() throws InterruptedException {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.CheckAuthSuc(getLogin(), getPassword());

        EditPage editPage = Selenide.page(EditPage.class);
        editPage.editCard("TestCard");

        editPage.openPost();
        SelenideElement  searchElement = $("tbody tr td");
        Assertions.assertEquals("96870", searchElement.getText());
    }

    @Test
    void checkAuthFailed() {
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.CheckAuthFailed();
        SelenideElement elementSearch = $x("//h2[text()='401']");
        Assertions.assertEquals("401", elementSearch.getText());

    }
}
