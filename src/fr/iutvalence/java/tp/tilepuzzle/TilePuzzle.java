package fr.iutvalence.java.tp.tilepuzzle;

/**
 * Classe principale du jeu, initialise la partie en créant un plateau et un joueur.
 */
public class TilePuzzle
{
	/**
	 * Plateau
	 */
	private final Plateau plateau;
	
	/**
	 * Joueur
	 */
	private final Joueur joueur;
	
	/**
	 * Support d'affichage
	 */
	private final Affichage affichage;
	
	/**
	 * Nombre de coups effectuées
	 */
	private int coups;
	
	/**
	 * Crée une partie prête à être jouée.
	 * Cela implique la mise en place d'un plateau et d'un joueur pour cette partie.
	 * @param joueur Joueur a utiliser
	 * @param plateau plateau à utiliser
	 * @param affichage Affichage a utiliser
	 */
	public TilePuzzle(Joueur joueur, Plateau plateau, Affichage affichage)
	{
		// TODO définir des constantes
		this.plateau = plateau;
		this.joueur = joueur;
		this.affichage = affichage;
		this.coups = 0;
	}

	/**
	 * Lance la partie
	 */
	public void jouer()
	{
		while (this.plateau.obtenirNombreDeCasesAllumees() < this.plateau.obtenirHauteur()*this.plateau.obtenirLargeur())
		{
			this.affichage.afficherPlateau(this.plateau);
			this.affichage.afficherDemandePosition();
			this.plateau.inverserCasesAutourDe(this.joueur.getPosition(this.plateau.obtenirHauteur(),this.plateau.obtenirLargeur()));
			this.coups++;
		}
		this.affichage.afficherPlateau(this.plateau);
		this.affichage.victoire(this.coups);
	}
}
