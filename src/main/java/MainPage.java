import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
     private final SelenideElement createNewPost = $x("create-btn");

    public void createPost() {
        createNewPost.shouldBe(visible).click();
    }
}