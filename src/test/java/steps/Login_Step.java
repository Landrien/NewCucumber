package steps;
import Page.Login_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BaseTest.BaseTest.driver;

public class Login_Step {

    Login_Page login = new Login_Page();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("L'utilisateur est sur la page de connexion")
    public void lUtilisateurEstSurLaPageDeConnexion() {
        login.driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @When("L'utilisateur saisit son username {string} invalide")
    @When("L'utilisateur saisit son username {string}")
    public void lUtilisateurSaisitSon(String arg0) {
        login.username.sendKeys(arg0);
    }

    @When("L'utilisateur saisit son password {string} invalide")
    @And("L'utilisateur saisit son password {string}")
    public void lUtilisateurSaisitSonPassword(String arg0) {
        login.password.sendKeys(arg0);
    }

    @And("L'utilisateur clique sur le bouton de connexion")
    public void lUtilisateurCliqueSurLeBoutonDeConnexion() {
        login.loginButton.click();
    }


    @Then("L'utilisateur reste sur la page de connexion")
    public void lUtilisateurResteSurLaPageDeConnexion() {
       WebElement element = wait.until(ExpectedConditions.visibilityOf(login.getErrorMessage()));
       assert(element.getText().equals("Error!"));
    }
}
