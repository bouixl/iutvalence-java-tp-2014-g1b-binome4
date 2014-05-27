package fr.iutvalence.java.tp.tilepuzzle;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @author bouixl
 * Bouton étendu, associé à une Position et immédiatemment surveillé par un ActionListener.
 */
public class JButtonCase extends JButton
{
	/**
	 * Position du bouton
	 */
	private final Position position;
	
	/**
	 * Etat du bouton
	 */
	private boolean etat;
	
	/**
	 * Crée un bouton pour la position indiquée
	 * @param position position qui sera enregistrée sur le bouton
	 * @param etat etat du bouton à sa création
	 * @param affichage Affichage qui ecoutera l'évènement
	 */
	public JButtonCase(Position position, boolean etat, Affichage affichage)
	{
		this.position = position;
		changerEtat(etat);
		this.addActionListener((ActionListener) affichage);
	}
	
	/**
	 * @return la position de cet objet
	 */
	public Position obtenirPosition()
	{
		return this.position;
	}

	/**
	 * @return l'etat
	 */
	public boolean obtenirEtat()
	{
		return this.etat;
	}

	/**
	 * Inverse l'état du bouton
	 * @param etat Etat a assigner au bouton
	 */
	public void changerEtat(boolean etat)
	{
		this.etat = etat;
		if(this.etat)
		{
			this.setBackground(new Color(255,255,255));
		}
		else
		{
			this.setBackground(new Color(0,0,0));
		}
	}
	
}
