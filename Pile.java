package Karmaka;

import java.util.ArrayList;

public class Pile extends Plateau {
/**
   * Permet de representer l'ensemble des carte qui constitue la main
   * @param carte
   * @author Richanel Mbou
 * @version 1.0
   */
	
	
	public Pile(ArrayList<Carte> carte) {
		super(carte);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterCarte(Carte c) {
		// TODO Auto-generated method stub
/**
		 * Permet d'ajouter une carte a la pile
		 * @author Richanel Mbou
 * @version 1.0
		 */
		carte.add(c);
		
		
	}

	@Override
	public void piocherCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}
	
	
public void affichP() {
		
	System.out.println("----PILE------");
		for( int i=0; i<carte.size();i++) {
			
			System.out.println(carte.get(i).getNomCarte()+"    "+carte.get(i).getPoint_Carte()+"    "+carte.get(i).getLibelle_pouvoir()+" "+carte.get(i).getCouleur().name());
		
		}
		
	}


}
