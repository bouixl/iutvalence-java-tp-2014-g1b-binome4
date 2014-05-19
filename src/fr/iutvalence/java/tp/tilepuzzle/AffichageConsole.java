package fr.iutvalence.java.tp.tilepuzzle;

/**
 * Gere l'affichage dans la console
 */
public class AffichageConsole implements Affichage
{
	@Override
	public void afficherPlateau(Plateau plateau)
	{
		/**
		 * Renvoi le contenu du plateau sous forme d'une chaine
		 * 
		 * @return Chaine representant le plateau
		 */

		String plateauAffichable = "";
		for (int ligne = 0; ligne < plateau.obtenirHauteur(); ligne++)
		{
			for (int colonne = 0; colonne < plateau.obtenirLargeur(); colonne++)
			{
				if (plateau.estCaseAllumee(new Position(ligne, colonne)))
				{
					plateauAffichable += "O ";
				}
				else
				{
					plateauAffichable += "- ";
				}
			}
			plateauAffichable += "\n";
		}
		System.out.println(plateauAffichable);
	}

	@Override
	public void afficherDemandePosition()
	{
		System.out.println("Position à inverser ?");

	}

	@Override
	public boolean obtenirPret()
	{
		return true;		
	}

}
