package Lesson3;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
public class EditPage {

    private SelenideElement firstDummy = $$("div.posts.svelte-127jg4t a").first();
    private SelenideElement dummyButtonEditPost = $x("//*[text()='edit']");
    private SelenideElement fieldToTitle = $$("input[type='text']").first();
    private SelenideElement saveButton = $x("//*[@type='submit']");
    private SelenideElement buttonUserPage = $x("//a[contains(text(),'Hello')]");
    private SelenideElement buttonEditPost = $$("ul.mdc-deprecated-list li").first();

    public void editCard(String name) {
        firstDummy.click();
        sleep(5000);
        dummyButtonEditPost.click();
        fieldToTitle.clear();
        fieldToTitle.setValue(name);
        saveButton.click();
    }

    public void openPost() {
        sleep(5000);
        buttonUserPage.click();
        buttonEditPost.click();
    }

}