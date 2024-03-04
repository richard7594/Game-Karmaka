package Karmaka;

import java.util.ArrayList;

public class Vie_future extends Plateau {

/**
 * Reprensente l'ensemble des carte qui constitue la vie future 	
 *  @author Richanel Mbou
 * @version 1.0
 * @param carte
 */
	
	
	
	
	public Vie_future(ArrayList<Carte> carte) {
		super(carte);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterCarte(Carte c) {
		// TODO Auto-generated method stub
		carte.add(c);
		
/*
		 * permet d'ajouter une carte a la vie future
		 * @author Richanel Mbou
 * @version 1.0
		 */
	}

	@Override
	public void piocherCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}
	
	

	public void affichF() {
		
		System.out.println("------Vie_Future-------");
		for( int i=0; i<carte.size();i++) {
			
			System.out.println(carte.get(i).getNomCarte()+"    "+carte.get(i).getPoint_Carte()+"    "+carte.get(i).getLibelle_pouvoir()+"  "+carte.get(i).getCouleur().name());
		}
		
	}

}
