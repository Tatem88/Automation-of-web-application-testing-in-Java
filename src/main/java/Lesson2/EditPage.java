package Lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {

    @FindBy(xpath = "//div[@class='posts svelte-127jg4t']/a[1]")
    private WebElement firstDummy;

    @FindBy(xpath = "//*[text()='edit']")
    private WebElement dummyButtonEditPost;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement fieldToTitle;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[contains(text(),'Hello')]")
    private WebElement buttonUserPage;
    @FindBy(xpath = "//ul[@class='mdc-deprecated-list']/li")
    private WebElement buttonEditPost;

    public EditPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void editCard(String name) throws InterruptedException {
        firstDummy.click();
        Thread.sleep(5000L);
        dummyButtonEditPost.click();
        fieldToTitle.clear();
        fieldToTitle.sendKeys(name);
        saveButton.click();
    }

    public void openPost() throws InterruptedException {
        Thread.sleep(5000l);
        buttonUserPage.click();
        buttonEditPost.click();
    }

}
