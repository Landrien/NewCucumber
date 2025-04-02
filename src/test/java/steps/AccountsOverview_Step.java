package steps;
import BaseTest.BaseTest;
import Page.AccountsOverview_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsOverview_Step extends BaseTest {

    AccountsOverview_Page AcO = new AccountsOverview_Page();
    @Given ("L'utilisateur est sur la page d'accueil")
    @Then("L'utilisateur est redirigé vers la page d'accueil")
    public void lUtilisateurEstRedirigéVersLaPageDAccueil() {
        assert(AcO.accountsOverviewHeader.isDisplayed());
    }


    @When("Je clique sur le bouton de création de compte")
    public void jeCliqueSurLeBoutonDeCréationDeCompte() {
        AcO.OpenNewAccountButton.click();
    }

    @When("Je clique sur l'un des comptes")
    public void jeCliqueSurLUnDesComptes() {
        AcO.Account1.click();
    }

    @Then("Je regarde si le compte est bien affiché")
    public void jeRegardeSiLeCompteEstBienAffiché() {
        assert(AcO.AccountId.isDisplayed());
        assert(AcO.Balance.isDisplayed());
        assert(AcO.AccountType.isDisplayed());
        assert(AcO.AvailableBalance.isDisplayed());

    }
}
