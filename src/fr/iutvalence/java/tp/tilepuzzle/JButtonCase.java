package fr.iutvalence.java.tp.tilepuzzle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JButtonCase extends JButton implements ActionListener
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
	 */
	public JButtonCase(Position position, boolean etat)
	{
		this.position = position;
		changerEtat(etat);
		this.addActionListener(this);
	}
	
	/**
	 * @return la position de cet objet
	 */
	public Position obtenirPosition()
	{
		return this.position;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		
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
			this.setBackground(new Color(0,255,0));
		}
		else
		{
			this.setBackground(new Color(255,0,0));
		}
	}
	
}
