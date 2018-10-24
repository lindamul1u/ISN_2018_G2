package projetLabyrinthe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LabyFichier
{
	public final int LARGEUR = 10;
	public final int HAUTEUR = 7;
	private char[][] map;

	public LabyFichier(String nomFichier) throws IOException
	{
		map = fileToArray(nomFichier);
	}
	
	public char[][] getMap()
	{
		return map;
	}
	
	public void setMap(char[][] map)
	{
		this.map = map;
	}

	public void afficheLaby()
	{
		for (int i = 0; i < this.map.length; i++)
		{
			for (int j = 0; j < this.map[0].length; j++)
			{
				System.out.print(this.map[i][j]);
			}
			System.out.println();
		}
	}

	private static char[][] fileToArray(String nomFichier) throws IOException
	{
		String[] raw = lireFichier(nomFichier).split("\n");
		char[][] res = new char[raw.length][raw[0].split("").length];
		// System.out.println(Arrays.toString(raw));
		// System.out.println("raw.length: " + raw.length);
		for (int i = 0; i < raw.length; i++)
		{
			String[] ligne = raw[i].split("");
			// System.out.println(raw[i]);
			// System.out.println("ligne[i].length: "+ligne.length);
			for (int j = 0; j < ligne.length; j++)
			{
				// System.out.println(ligne);
				// res[i][j] = '1'; //test
				// ************************
				switch (ligne[j])
				{
				//mur
				case "1":
					res[i][j] = '#';
					break;
				//emplacement vide
				case "0": 
					res[i][j] = ' ';
					break;
				//entree du laby
				case "2": 
					res[i][j] = 'E';
					break;
				//case piege
				case "3":
					res[i][j] = 'X';
					break;
				//case passage
				case "4":
					res[i][j] = 'O';
					break;
				//case magique 
				case "5":
					res[i][j] = '*';
					break;
				//case tr�sor
				case "6":
					res[i][j] = '$';
					break;
				
					
				default:
					break;
				}

				// ***********************
			}
		}
		return res;
	}

	public static String lireFichier(String nomFichier) throws IOException
	{
		File f = new File(nomFichier);
		BufferedReader fR = new BufferedReader(new FileReader(f));
		String chaine = "";
		String chaine_totale = "";
		do
		{
			chaine = fR.readLine();
			if (chaine != null)
			{
				chaine_totale += chaine + "\n";
			}
		} while (chaine != null);
		fR.close();
		return (chaine_totale);
	}

	

	public void setMap (int abscisse, int ordonnee, char carac) // change un caract�re de la map
	{
		// le caractere en haut a gauche est le [0][0]
		if (abscisse>=0 && ordonnee>=0 && abscisse<this.HAUTEUR && ordonnee<this.LARGEUR)
		{
			this.map[abscisse][ordonnee]=carac;
		} else System.out.println("setMap: Veuillez entrer une abscisse et une ordonn�e valide !");
	}

	
	
	 
}
