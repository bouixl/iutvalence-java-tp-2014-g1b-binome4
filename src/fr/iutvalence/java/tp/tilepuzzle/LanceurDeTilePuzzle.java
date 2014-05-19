package fr.iutvalence.java.tp.tilepuzzle;

import javax.swing.SwingUtilities;

/**
 * @author Bouix Loïc et Sanfilippo Max
 */

/**
 * Classe initiale de l'application, permet de lancer la partie.
 */
public class LanceurDeTilePuzzle
{
	/**
	 * Methode initiale, crée la partie et affiche son 
	 * état actuel(en création, démarrage ou terminé)
	 * @param args Arguments de la ligne de commande, il n'y en a aucun pour
	 * l'instant.
	 */
	public static void main(String[] args)
	{
		System.out.println("Création de la partie");
		Joueur joueur = new JoueurClavier();
		
		FabriqueDePlateau fdp = new FabriqueDePlateauAleatoire();
		Plateau plateau = fdp.obtenirPlateauDefini(3, 3, 10);
		
		Affichage affichage = new AffichageFenetre(plateau);
		
		// TODO: Retirer ça
		Affichage affichageDebug = new AffichageConsole();
		affichageDebug.afficherPlateau(plateau);
		
		SwingUtilities.invokeLater((Runnable) affichage);
		
		TilePuzzle partieDeTilePuzzle = new TilePuzzle(joueur, plateau, affichage);
		System.out.println("Demarrage de la partie");
		while(!affichage.obtenirPret()) { }
		partieDeTilePuzzle.jouer();
		System.out.println("Fin de la partie");
	}
}