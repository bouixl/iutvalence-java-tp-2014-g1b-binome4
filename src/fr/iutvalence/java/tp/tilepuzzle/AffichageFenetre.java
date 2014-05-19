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
	 * Fenetre de l'application
	 */
	private JFrame fenetre;
	
	/**
	 * Panneau principal de l'application
	 */
	private JPanel panneau;
	
	/** 
	 * Indicateur d'état de l'interface graphique
	 */
	private boolean pret;
	
	/**
	 * @param plateau Plateau servant  à initialiser l'affichage
	 */
	public AffichageFenetre(Plateau plateau)
	{
		this.pret = false;
		this.hauteurGrille = plateau.obtenirHauteur();
		this.largeurGrille = plateau.obtenirLargeur();
	}
	
	@Override
	public boolean obtenirPret()
	{
		return this.pret;
	}

	@Override
	public void run()
	{
		this.fenetre = new JFrame();
		this.fenetre.setTitle("Tile Puzzle");
		this.fenetre.setSize(500, 500);
		this.fenetre.setResizable(false);
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		this.panneau = new JPanel();
		
		this.fenetre.add(this.panneau);
		this.panneau.setLayout(new GridLayout(this.largeurGrille,this.hauteurGrille));
		
		this.fenetre.setVisible(true);
		
		this.pret = true;
	}
	
	@Override
	public void afficherPlateau(Plateau plateau)
	{
		this.panneau.removeAll();
		for (int ligne = 0; ligne < this.hauteurGrille; ligne++)
		{
			for (int colonne = 0; colonne < this.largeurGrille; colonne++)
			{
				if (plateau.estCaseAllumee(new Position(ligne, colonne)))
				{
					this.panneau.add(new JButtonCase(new Position(ligne, colonne),true));
				}
				else
				{
					this.panneau.add(new JButtonCase(new Position(ligne, colonne),false));
				}
			}
		}
	}

	@Override
	public void afficherDemandePosition()
	{
		
	}

}
