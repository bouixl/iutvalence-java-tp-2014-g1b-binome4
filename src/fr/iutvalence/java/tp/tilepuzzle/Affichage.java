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
}
