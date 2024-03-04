package Karmaka;

import java.util.ArrayList;
import java.util.Iterator;

public class Oeuvre extends Plateau {
	
/**
	 * Represente l'ensemble des cartes constituant l'oeuvre d'un joueur 
	 * @param carte
	 * @author Richanel Mbou
     * @version 1.0
	 */

	public Oeuvre(ArrayList<Carte> carte) {
		super(carte);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterCarte(Carte c) {
		// TODO Auto-generated method stub
		carte.add(c);
		
/**
		 * @author Richanel Mbou
         * @version 1.0
		 * Permet d'ajouter une carte au oeuvre
		 */
	}

	@Override
	public void piocherCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	public int countPointO() {
		
/**
		 * Permet de compter le nombres de point des oeuvre selon les criteres du jeu
		 * @return point
		 * @author Richanel Mbou
         * @version 1.0
		 */
		// Ta pas encore faire pour  Mosaique
		int pointB=0;
		int pointR=0;
		int pointV=0;
		int pointM=0;
		
		Iterator<Carte> it = carte.iterator();
		
		while(it.hasNext()) {
			
			Carte c= it.next();
			Couleur clr = null;
			if(c.getCouleur().equals(clr.bleue)) {
				
				pointB=pointB+c.getPoint_Carte();
		      
			}else if(c.getCouleur().equals(clr.verte)) {
				
				pointV=pointV+c.getPoint_Carte();
		      
			}else if(c.getCouleur().equals(clr.rouge)) {
				
				pointR=pointR+c.getPoint_Carte();
		      
			}else if(c.getCouleur().equals(clr.Mosaique)) {
				
				pointM=pointM+c.getPoint_Carte();
		      
			}
				
		}
			
		//Expression reguliere
		int point= (pointB > pointR) ? (pointB> pointV ? pointB:pointV) : (pointR > pointV ? pointR: pointV);	//Le maximun par couleur
		
		return point + pointM;
	}
	
	
	
	
	
	
	
public void affichO() {
		
		System.out.println("------Oeuvre-------");
		for( int i=0; i<carte.size();i++) {
			
			System.out.println(carte.get(i).getNomCarte()+"    "+carte.get(i).getPoint_Carte()+"    "+carte.get(i).getLibelle_pouvoir()+"  "+carte.get(i).getCouleur().name());
		}
		
	}


}
