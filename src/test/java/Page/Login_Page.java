package Page;

import BaseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

    public WebDriver driver;
    @FindBy(name = "username")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//input[@value = 'Log In']")
    public WebElement loginButton;
    @FindBy(xpath = "//h1")
    public WebElement errorMessage;

    public Login_Page() {
        this.driver = BaseTest.driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
