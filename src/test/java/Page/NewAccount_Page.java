package Page;

import BaseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccount_Page extends BaseTest {

    public WebDriver driver;

    @FindBy(xpath = "//input")
    public WebElement OpenNewAccountButton;
    @FindBy(id ="openAccountForm")
    public WebElement openAccountForm;

    public NewAccount_Page() {
        this.driver = BaseTest.driver;
        PageFactory.initElements(driver, this);
    }

}
