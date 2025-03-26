package steps;
import Page.NewAccount_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class NewAccount_Step {
    NewAccount_Page newAccount_page = new NewAccount_Page();

    @And("Je clique sur le bouton de création du compte")
    public void jeCliqueSurLeBoutonDeCréationDuCompte() {
        newAccount_page.OpenNewAccountButton.click();
    }


    @Then("Je verifie que le compte est bien créé")
    public void jeVerifieQueLeCompteEstBienCréé() {
        assert(newAccount_page.openAccountForm.isDisplayed());    }

}
