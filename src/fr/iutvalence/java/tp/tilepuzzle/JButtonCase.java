package fr.iutvalence.java.tp.tilepuzzle;

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
	 * Crée un bouton pour la position indiquée
	 * @param position position qui sera enregistrée sur le bouton
	 */
	public JButtonCase(Position position)
	{
		this.position = position;
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
	
}
