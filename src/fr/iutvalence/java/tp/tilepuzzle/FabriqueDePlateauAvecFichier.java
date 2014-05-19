package fr.iutvalence.java.tp.tilepuzzle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

public class FabriqueDePlateauAvecFichier implements FabriqueDePlateau
{

	/**
	 * Chemin du fichier contenant le plateau
	 */
	private final static String FICHIER = "plateau";
	
	@Override
	public Plateau obtenirPlateau()
	{
		File fichier = new File(FICHIER);
		FileInputStream fileStream = null;
		try
		{
			fileStream = new FileInputStream(fichier);
		}
		catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		InputStreamReader isr = null;
		try
		{
			isr = new InputStreamReader(fileStream, "US-ASCII");
		}
		catch (UnsupportedEncodingException e)
		{
			// Ignore it, US-ASCII is always supported
		}
		BufferedReader fileReader = new BufferedReader(isr);
		
		int hauteur = 0;
		try
		{
			hauteur = Integer.parseInt(fileReader.readLine());
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int largeur = 0;
		try
		{
			largeur = Integer.parseInt(fileReader.readLine());
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<Position> cases = new HashSet<Position>();	
		Plateau plateau = new Plateau(hauteur, largeur, cases);
		
		// TODO: Ajouter le remplissage des cases du tableau
		// TODO : attention, en cas d'erreur il serait plus judicieux de retourner null
		
		try
		{
			fileReader.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plateau;
	}

	@Override
	public Plateau obtenirPlateauDefini(int hauteur, int largeur, int difficulte)
	{
		FabriqueDePlateauAleatoire fdp = new FabriqueDePlateauAleatoire();
		return fdp.obtenirPlateau();
	}
}
