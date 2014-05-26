package fr.iutvalence.java.tp.tilepuzzle;

/**
 * Interface définissant les méthodes relatives à l'affichage
 */
public interface Affichage
{
	
	/**
	 * Renvoie si l'interface est prete a être utilise ou non
	 * @return etat de l'interface
	 */
	public boolean obtenirPret();
	
	/**
	 * Affiche la demande de position
	 */
	public void afficherDemandePosition();
	
	/**
	 * Affiche le plateau transmis
	 * @param plateau Plateau a afficher
	 */
	public void afficherPlateau(Plateau plateau);

	/**
	 * Affiche le message de victoires et le nombre de coups effectués
	 * @param coups nombre de coups effectués
	 */
	public void victoire(int coups);
}
