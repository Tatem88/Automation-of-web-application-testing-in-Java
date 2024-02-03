package Lesson3;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement createNewPost = $("#create-btn");

    public void createPost() {
        createNewPost.click();
    }

}
