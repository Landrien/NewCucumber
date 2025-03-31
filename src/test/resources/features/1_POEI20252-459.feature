Feature: Connexion Valide ParaBank

	@POEI20252-459 @Hadrien @ParaBank
	Scenario: Connexion Valide ParaBank
		Given L'utilisateur est sur la page de connexion
		When L'utilisateur saisit son username "john"
		And L'utilisateur saisit son password "demo"
		And L'utilisateur clique sur le bouton de connexion
		Then L'utilisateur est redirigé vers la page d'accueil
		
