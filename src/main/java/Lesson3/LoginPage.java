package Lesson3;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    private SelenideElement loginField = $x("//*[@type='text']");
    private SelenideElement passwordField = $x("//*[@type='password']");
    private SelenideElement button = $x("//button[@type='submit']");

    public void CheckAuthSuc(String username, String password) {
        loginField.setValue(username);
        passwordField.setValue(password);
        button.click();
    }

    public void CheckAuthFailed() {
        button.shouldBe(visible).click();
    }

}
