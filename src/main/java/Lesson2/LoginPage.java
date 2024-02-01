package Lesson2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

    @FindBy(xpath = "//*[@type='text']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement button;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void CheckAuthSuc(String username, String password) {
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        button.click();
    }

    public void CheckAuthFailed() {
        button.click();
    }

}
