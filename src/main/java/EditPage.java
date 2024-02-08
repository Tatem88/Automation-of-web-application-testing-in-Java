import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EditPage {
    private final SelenideElement firstDummy = $x("//div[@class='posts svelte-127jg4t']/a");
    private final SelenideElement dummyButtonEditPost = $x("//div[@class='button-block svelte-tv8alb']/button");
    private final SelenideElement fieldToTitle = $x("//input[@type='text']");
    private final SelenideElement saveButton = $x("//*[@type='submit']");
    private final SelenideElement buttonUserPage = $x("//a[contains(text(),'Hello')]");
    private final SelenideElement buttonEditPost = $x("//ul[@class='mdc-deprecated-list']/li");

    public void editCard(String name) throws InterruptedException {
        firstDummy.shouldBe(visible).click();
        Thread.sleep(5000L);
        dummyButtonEditPost.shouldBe(visible).click();
        fieldToTitle.clear();
        fieldToTitle.sendKeys(name);
        saveButton.click();
    }

    public void openPost() throws InterruptedException {
        Thread.sleep(5000l);
        buttonUserPage.shouldBe(visible).click();
        buttonEditPost.shouldBe(visible).click();
    }
}