package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverview_Page {
    public WebDriver driver;

    @FindBy(xpath = "//h1")
    public WebElement accountsOverviewHeader;
    @FindBy(xpath = "//div[@id = 'leftPanel']/ul/li/a")
    public WebElement OpenNewAccountButton;
    @FindBy(xpath = "//table/tbody/tr[1]/td/a")
    public WebElement Account1;
    @FindBy(id = "accountId")
    public WebElement AccountId;
    @FindBy(id = "balance")
    public WebElement Balance;
    @FindBy(id = "accountType")
    public WebElement AccountType;
    @FindBy(id = "availableBalance")
    public WebElement AvailableBalance;

    public AccountsOverview_Page() {
        this.driver = BaseTest.BaseTest.driver;
        PageFactory.initElements(driver, this);
    }
}
