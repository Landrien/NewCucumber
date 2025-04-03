Feature: Création de compte

  Background: Connexion de l'utilisateur
    Given L'utilisateur est sur la page de connexion
    When L'utilisateur saisit son username "john"
    And L'utilisateur saisit son password "demo"
    And L'utilisateur clique sur le bouton de connexion
    Then L'utilisateur est redirigé vers la page d'accueil

  Scenario: Création de compte
    Given L'utilisateur est sur la page d'accueil
    When Je clique sur le bouton de création de compte
    And Je clique sur le bouton de création du compte
    Then Je verifie que le compte est bien créé
