import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement loginField = $x("//*[@type='text']");
    private final SelenideElement passwordField = $x("//*[@type='password']");
    private final SelenideElement button = $x("//*//button[@type='submit']");

    public void CheckAuthSuc(String username, String password) {
        loginField.shouldBe(visible).sendKeys(username);
        passwordField.shouldBe(visible).sendKeys(password);
        button.shouldBe(visible).click();
    }

    public void CheckAuthFailed() {
        button.shouldBe(visible).click();
    }

}
