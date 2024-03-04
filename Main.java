package Karmaka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Plateau {

/**
	 * Classe representant la main d'un joueur
	 * @author Richanel Mbou
     * @version 1.0
	 * @param carte
	 */
	
	public Main(ArrayList<Carte> carte) {
		super(carte);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void ajouterCarte(Carte c) {
		// TODO Auto-generated method stub
/**
		  * permet d'ajouter une carte a la main
		  * @author Richanel Mbou
          * @version 1.0
		  */
		
		carte.add(c);	
	}

	@Override
	public void piocherCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}
	
	public void affichM() {
		
/**
		 * Permet d'afficher les cartes de la main sur la console
		 * @author Richanel Mbou
         * @version 1.0
		 */
		
		System.out.println("------Main-------");
		for( int i=0; i<carte.size();i++) {
			
			System.out.println(carte.get(i).getNomCarte()+"    "+carte.get(i).getPoint_Carte()+"    "+carte.get(i).getLibelle_pouvoir()+"  "+carte.get(i).getCouleur().name());
		}
		
	}
	
	

	
	
	
	
	
	
	

}
