package Karmaka;

import java.util.ArrayList;

public abstract class Plateau {
/**
	 * represente l'ensemble des compartiments de carte dont dispose un joueur
	 * @author Richanel Mbou
 * @version 1.0 
	 */
	ArrayList <Carte> carte = new ArrayList<Carte> ();
	
	
	public Plateau(ArrayList<Carte> carte) {
		
		this.carte = carte;
	}
	public abstract void ajouterCarte(Carte c);
	public abstract void piocherCarte(Carte c);

}
