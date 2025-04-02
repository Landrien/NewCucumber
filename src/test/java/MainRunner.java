import Automatisation.Connexion;
import Automatisation.GetFeature;
import org.junit.runner.JUnitCore;
import runner.RunnerTest;

import java.io.IOException;

public class MainRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Création Objet et récupération du token, cette classe permet d'effectuer les requêtes API
              String token = Connexion.getToken();
        //Récupère fichier zip compressé
        GetFeature.getFeature(token);

            //Permet de run mon runner de test
            JUnitCore.runClasses(RunnerTest.class);

    }
}