package fr.iutvalence.java.tp.tilepuzzle;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/**
 * Gère l'affichage dans une fenêtre
 */
public class AffichageFenetre implements Runnable, Affichage
{
	/**
	 * Hauteur de la grille
	 */
	private final int hauteurGrille;	
	/**
	 * Largeur de la grille
	 */
	private final int largeurGrille;
	
	/**
	 * @param plateau Plateau servant  à initialiser l'affichage
	 */
	public AffichageFenetre(Plateau plateau)
	{
		this.hauteurGrille = plateau.obtenirHauteur();
		this.largeurGrille = plateau.obtenirLargeur();
	}
	
	@Override
	public void run()
	{
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Tile Puzzle");
		fenetre.setSize(500, 500);
		fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JPanel panneau = new JPanel();
		
		fenetre.add(panneau);
		panneau.setLayout(new GridLayout(this.largeurGrille,this.hauteurGrille));
		
		
		
		fenetre.setVisible(true);
	}
	
	@Override
	public void afficherPlateau(Plateau plateau)
	{
		
	}

	@Override
	public void afficherDemandePosition()
	{
		
	}

}
