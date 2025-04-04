Feature Test Banquaire

  Background: Connexion de l'utilisateur
    Given L'utilisateur est sur la page de connexion
    When L'utilisateur saisit son username "john"
    And L'utilisateur saisit son password "demo"
    And L'utilisateur clique sur le bouton de connexion
    Then L'utilisateur est redirigé vers la page d'accueil

  Scenario: Verification des données de l'utilisateur
    Given L'utilisateur est sur la page d'accueil
    When Je clique sur l'un des comptes
    Then Je regarde si le compte est bien affiché