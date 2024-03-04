package Karmaka;

import java.util.ArrayList;
import java.util.Iterator;

public class Fausse {
	
/**
	 * Class represent la fosse du jeux
	 * @author Richanel Mbou
	 * @version 1.0
	 */
	ArrayList<Carte> fausse = new ArrayList<Carte>();
	ArrayList<Carte> o = new ArrayList<Carte>();
	Carte c;

	// tout les attributs qui est public 
	
	// deux constructeur
	
	public Fausse(ArrayList<Carte> o ,ArrayList<Carte> fausse) {
	
		this.fausse = fausse;
		this.o=o;
		
		
	}
	
	
	public void defausser() {
/**
		 * Methode permettant de defausser une carte
		 * @author Richanel Mbou
         * @version 1.0
		 */
		Iterator<Carte> it = o.iterator();
		while(it.hasNext()) {
			
			fausse.add(it.next());
			
		}
		o.clear();
	}
	
//Surchage de la methode 
	
	public void defausser(Carte c ) {
/**
		 * Surchage de defausser
		 * @author Richanel Mbou
         * @version 1.0 
		 * @parm carte c
		 */
			
			fausse.add(c);
	}
		
	
}
