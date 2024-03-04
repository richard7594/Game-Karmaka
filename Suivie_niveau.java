package Karmaka;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Suivie_niveau {
/*
	 * Permet de gerer et voir l'evolution d'un joueur sur l'echelle karmique
	 * @author Richanel Mbou
     * @version 1.0
	 */

	ArrayList<Echelle_karmique> echelle = new ArrayList<Echelle_karmique>();
	ArrayList<Echelle_karmique> old_echelle = new ArrayList<Echelle_karmique>();
	
	Echelle_karmique ek;
	
	private int point_Karmique = 0 ;
	
	private PropertyChangeSupport end_game = new  PropertyChangeSupport(this);	
	
	
	public Suivie_niveau () {
		
		
		addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				
				
				if(evt.getPropertyName().equals("echelle")) {
					
					ArrayList<Echelle_karmique> new_ve = (ArrayList<Echelle_karmique>) evt.getNewValue();
					
					if(new_ve.contains(ek.Transcendence) ){
						
						JOptionPane.showMessageDialog(null, "*****Felicitation vous avez gagnez*****" );
						System.exit(0);
					}
					
				}
					
			}
			
		});
		
		
	}
	
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		
		end_game.addPropertyChangeListener(listener);
	}
	
	public void evolution() {
		
		
		end_game.firePropertyChange("echelle", old_echelle,echelle);
		
	}
	
	
	
	
	public void afficher_niveau() {
		
/**
		 * Affiche le niveau d'un joueur sur l'echelle karmique 
		 * @author Richanel Mbou
 * @version 1.0
		 */
		
if(! echelle.isEmpty()) { JOptionPane.showMessageDialog(null, "Vous etes au niveau "+echelle.get(echelle.size()-1).name()+" equivaut a "+echelle.get(echelle.size()-1).getPoint_Karmique());}	
else {JOptionPane.showMessageDialog(null,"Vous etes au niveau Bousier"); }
}
	
	
	public void next_niveau(Oeuvre oeuvre) {
		
		 old_echelle.clear();
	
         for(int i=0; i<echelle.size();i++) {
	 
			
			 old_echelle.add(this.echelle.get(i));
		 }
		
         
         
         
         
         
		
		int count = oeuvre.countPointO() + point_Karmique;
		
		
		
		System.out.print(count);
		
		
         
		
         if(count >= ek.Serpent.getPoint_Karmique() && !echelle.contains(ek.Serpent) ) {
			
			echelle.add(ek.Serpent);
			point_Karmique =0;
			
		}else if(count >= ek.Loup.getPoint_Karmique() && !echelle.contains(ek.Loup) ) {
			
			
			echelle.add(ek.Loup);
			point_Karmique =0;
			
		}else if(count >= ek.Singe.getPoint_Karmique() && !echelle.contains(ek.Singe) ) {
			
			echelle.add(ek.Singe);
			point_Karmique =0;
			
		}else if(count >= ek.Transcendence.getPoint_Karmique() && !echelle.contains(ek.Transcendence) ) {
			
			echelle.add(ek.Transcendence);
			point_Karmique =0;
			
		}
		
		  evolution(); // detecte les changement evolution dans l'echelle karmique
		
		
		//Gerer les points karmique
		
		if (echelle.equals(old_echelle)) {
			
			
			  JOptionPane.showMessageDialog(null, " vous vous etes reincarner au meme niveau ");
				  
			  JOptionPane.showMessageDialog(null, " vous aller avoir un anneau Karmique ");
			
				point_Karmique++;
				
			
		}
		
	}



	public int getPoint_Karmique() {
		return point_Karmique;
	}



	
	
	
	
}
