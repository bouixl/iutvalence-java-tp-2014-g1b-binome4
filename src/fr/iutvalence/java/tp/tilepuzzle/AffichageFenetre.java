package fr.iutvalence.java.tp.tilepuzzle;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

/**
 * Gère l'affichage dans une fenêtre
 */
public class AffichageFenetre implements Runnable, Affichage, Joueur, ActionListener
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
	 * Bouton "A Propos" dans le menu
	 */
	private JMenuItem menuItemAPropos;
	
	/**
	 * Bouton "Fermer" dans le menu
	 */
	private JMenuItem menuItemFermer;
	
	/** 
	 * Indicateur d'état de l'interface graphique
	 */
	private volatile boolean pret;
	
	/**
	 * Indicateur d'attente pour les evenements
	 */
	private volatile boolean attendreEvenement;
	
	/**
	 * Position transmise par le dernier évènement
	 */
	private Position positionAChanger;
	
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
		this.fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.fenetre.setLocationRelativeTo(null);

		JMenuBar barreDeMenu = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		
		this.menuItemAPropos = new JMenuItem("A propos");
		this.menuItemAPropos.addActionListener(this);
		menu.add(this.menuItemAPropos);

		this.menuItemFermer = new JMenuItem("Fermer");
		this.menuItemFermer.addActionListener(this);
		menu.add(this.menuItemFermer);
		
		barreDeMenu.add(menu);
		this.fenetre.setJMenuBar(barreDeMenu);

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
					this.panneau.add(new JButtonCase(new Position(ligne, colonne),true,this));
				}
				else
				{
					this.panneau.add(new JButtonCase(new Position(ligne, colonne),false,this));
				}
			}
		}
		this.panneau.updateUI();
	}

	@Override
	public void afficherDemandePosition()
	{

	}

	@Override
	public Position getPosition(int hauteurPlateau, int largeurPlateau)
	{
		this.attendreEvenement = true;
		while(this.attendreEvenement) 
		{
			try {
			    TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		return this.positionAChanger;
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();

		if (source == this.menuItemAPropos)
		{
			JOptionPane.showMessageDialog(this.fenetre, "Jeu de Tile Puzzle\nPar Loïc BOUIX et Max SANFILIPPO", "A propos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		else if (source == this.menuItemFermer)
		{
			if (JOptionPane.showConfirmDialog(this.fenetre, "Fermer l'application ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.fenetre.dispose();
		}
		else if(this.attendreEvenement)
		{
			this.positionAChanger = ((JButtonCase) event.getSource()).obtenirPosition();
			this.attendreEvenement = false;
		}
	}

	@Override
	public void victoire(int coups)
	{
		JOptionPane.showMessageDialog(this.fenetre, "Vous avez gagné en "+coups+" coups.", "Victoire !", JOptionPane.INFORMATION_MESSAGE);
	}

}
