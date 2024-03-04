package Karmaka;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Carte.Another_Day;
import Carte.Bassesse;
import Carte.Crisis;
import Carte.Denial;
import Carte.Destiny;
import Carte.Dwindle;
import Carte.Fournaise;
import Carte.Jubilee;
import Carte.Longevity;
import Carte.Mosaique;
import Carte.Panic;
import Carte.Peek;
import Carte.Recycle;
import Carte.Roulette;
import Carte.Salvage;
import Carte.Sowing;
import Carte.Stolen_dreams;
import Carte.Swindle;
import Carte.Thievery;
import Carte.Transmigrate;
import Carte.Vangeance;
import Carte.Voyage;

public class Partie {
	
	
	
	//Singleton
	
	private static Partie instance = new Partie();
	
	public static Partie getInstance() {
		
		return instance;
	}
	
	
	
	
	ArrayList <Carte> paquet = new ArrayList <Carte> ();
    
	public Suivie_niveau suivie = new Suivie_niveau();
	public Suivie_niveau suivie1 = new Suivie_niveau();
	public ArrayList <Carte> f = new ArrayList <Carte> ();
	

	   // 1er joueur
		public ArrayList<Carte> m = new ArrayList<Carte>();
		public ArrayList<Carte> p = new ArrayList<Carte>();
		public ArrayList<Carte> v = new ArrayList<Carte>();
		public ArrayList<Carte> o = new ArrayList<Carte>();
		
		// 2er joueur
			public ArrayList<Carte> m1 = new ArrayList<Carte>();
			public ArrayList<Carte> p1 = new ArrayList<Carte>();
			public ArrayList<Carte> v1 = new ArrayList<Carte>();
			public ArrayList<Carte> o1 = new ArrayList<Carte>();
			
		
		
		//1er joueur
	     public Oeuvre oeuvre = new Oeuvre(o);
		 public Main main = new Main(m);
	 	 public Pile pile = new Pile(p);
	 	public Vie_future vf = new Vie_future(v);
	 	

		//2eme joueur
	     public Oeuvre oeuvre1 = new Oeuvre(o1);
		 public Main main1 = new Main(m1);
	 	 public Pile pile1 = new Pile(p1);
	 	public Vie_future vf1 = new Vie_future(v1);
	 	
	 	
	 	 //Stockage
	 	ArrayList<Carte> old_m =new ArrayList<Carte>();
		ArrayList<Carte> old_p =new ArrayList<Carte>();
		ArrayList<Carte> old_m1 = new ArrayList<Carte>();
		ArrayList<Carte> old_p1 = new ArrayList<Carte>();
		
	
		public Fausse fausse = new Fausse(o,f); 
		public Fausse fausse1 = new Fausse(o1,f);
		
		
		
	public Partie( ) {
	
/**
		 * permet creation d'un paquet de carte et la detection des changements d'etait des objets main et pile
		 * @author Richanel Mbou
         * @version 1.0
		 */
		
	Couleur c = null;
	
	//ICI on vend  creer un paquet de carte apres avoir creer les differents classe de carte 
	
	//ICI on vend  creer un paquet de carte apres avoir creer les differents classe de carte 
	paquet.add(new Transmigrate(1,"Placez dans votre Main n'importe quelle carte de votre Vie Future.", c.bleue  ));
	paquet.add(new Transmigrate(1,"Placez dans votre Main n'importe quelle carte de votre Vie Future.", c.bleue  ));
	paquet.add(new Transmigrate(1,"Placez dans votre Main n'importe quelle carte de votre Vie Future.", c.bleue  ));
	paquet.add(new Peek(1, "Regardez la main d'un rival. Vous pouvez ensuite jouer une autre carte.", c.bleue ));
	paquet.add(new Peek(1, "Regardez la main d'un rival. Vous pouvez ensuite jouer une autre carte.", c.bleue ));
	paquet.add(new Peek(1, "Regardez la main d'un rival. Vous pouvez ensuite jouer une autre carte.", c.bleue ));
	paquet.add(new Destiny(2, "Regardez les 3 premières cartes de la  Source ;ajoutez-en jusqu'à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.", c.bleue ));
	paquet.add(new Destiny(2, "Regardez les 3 premières cartes de la  Source ;ajoutez-en jusqu'à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.", c.bleue ));
	paquet.add(new Destiny(2, "Regardez les 3 premières cartes de la  Source ;ajoutez-en jusqu'à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.", c.bleue ));
	paquet.add(new Stolen_dreams(2, "Placez la première carte de la Vie Future d'un rival sur la votre.", c.bleue));
	paquet.add(new Stolen_dreams(2, "Placez la première carte de la Vie Future d'un rival sur la votre.", c.bleue));
	paquet.add(new Stolen_dreams(2, "Placez la première carte de la Vie Future d'un rival sur la votre.", c.bleue));
	paquet.add(new Denial(2, "Défaussez une carte de votre Main. Copiez le pouvoir de cette carte.", c.bleue));
	paquet.add(new Denial(2, "Défaussez une carte de votre Main. Copiez le pouvoir de cette carte.", c.bleue));
	paquet.add(new Denial(2, "Défaussez une carte de votre Main. Copiez le pouvoir de cette carte.", c.bleue));
	paquet.add(new Swindle(3, "Regardez 3 cartes de la Main d'un rival; ajoutez-en une à votre Main.", c.bleue));
	paquet.add(new Swindle(3, "Regardez 3 cartes de la Main d'un rival; ajoutez-en une à votre Main.", c.bleue));
	paquet.add(new Thievery(3, "Placez dans votre Main l'Oeuvre Exposée d'un rival.", c.bleue));
	paquet.add(new Thievery(3, "Placez dans votre Main l'Oeuvre Exposée d'un rival.", c.bleue));
	paquet.add(new Another_Day(1, "Puisez une carte à la Source. Vous pouvez ensuite jouer une autre carte.", c.verte ));
	paquet.add(new Another_Day(1, "Puisez une carte à la Source. Vous pouvez ensuite jouer une autre carte.", c.verte ));
	paquet.add(new Another_Day(1, "Puisez une carte à la Source. Vous pouvez ensuite jouer une autre carte.", c.verte ));
	paquet.add(new Recycle(1, "Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse.", c.verte ));
	paquet.add(new Recycle(1, "Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse.", c.verte ));
	paquet.add(new Recycle(1, "Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse.", c.verte ));
	paquet.add(new Salvage(2, "Ajoutez à votre Main une des 3 dernières cartes de la Fosse.", c.verte ));
	paquet.add(new Salvage(2, "Ajoutez à votre Main une des 3 dernières cartes de la Fosse.", c.verte ));
	paquet.add(new Salvage(2, "Ajoutez à votre Main une des 3 dernières cartes de la Fosse.", c.verte ));
	paquet.add(new Longevity(2, "Placez 2 cartes puisées à la Source sur la Pile d'un Jouer.", c.verte ));
	paquet.add(new Longevity(2, "Placez 2 cartes puisées à la Source sur la Pile d'un Jouer.", c.verte ));
	paquet.add(new Longevity(2, "Placez 2 cartes puisées à la Source sur la Pile d'un Jouer.", c.verte ));
	paquet.add(new Sowing(2, "Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main", c.verte ));
	paquet.add(new Sowing(2, "Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main", c.verte ));
	paquet.add(new Sowing(2, "Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main", c.verte ));
	paquet.add(new Voyage(3, "Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre carte.", c.verte));
	paquet.add(new Voyage(3, "Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre carte.", c.verte));
	paquet.add(new Jubilee(3, "Placez jusqu'à 2 cartes de votre Main sur vos Oeuvres.", c.verte));
	paquet.add(new Jubilee(3, "Placez jusqu'à 2 cartes de votre Main sur vos Oeuvres.", c.verte));
	paquet.add(new Panic(1, "Défaussez la première carte de la Pile d'un jouer. Vous pouvez ensuite jouer une autre carte.", c.rouge));
	paquet.add(new Panic(1, "Défaussez la première carte de la Pile d'un jouer. Vous pouvez ensuite jouer une autre carte.", c.rouge));
	paquet.add(new Panic(1, "Défaussez la première carte de la Pile d'un jouer. Vous pouvez ensuite jouer une autre carte.", c.rouge));
	paquet.add(new Dwindle(1, "Le joueur de votre choix défausse une carte de sa Main.", c.rouge));
	paquet.add(new Dwindle(1, "Le joueur de votre choix défausse une carte de sa Main.", c.rouge));
	paquet.add(new Dwindle(1, "Le joueur de votre choix défausse une carte de sa Main.", c.rouge));
	paquet.add(new Crisis(2, "Le rival de votre choix défausse une de ses Oeuvres .", c.rouge));
	paquet.add(new Crisis(2, "Le rival de votre choix défausse une de ses Oeuvres .", c.rouge));
	paquet.add(new Crisis(2, "Le rival de votre choix défausse une de ses Oeuvres .", c.rouge));
	paquet.add(new Roulette(2, "Défaussez jusqu'à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1", c.rouge));
	paquet.add(new Roulette(2, "Défaussez jusqu'à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1", c.rouge));
	paquet.add(new Roulette(2, "Défaussez jusqu'à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1", c.rouge));
	paquet.add(new Fournaise(2, "Défaussez les 2 premières cartes de la Vie Future d'un rival", c.rouge));
	paquet.add(new Fournaise(2, "Défaussez les 2 premières cartes de la Vie Future d'un rival", c.rouge));
	paquet.add(new Fournaise(2, "Défaussez les 2 premières cartes de la Vie Future d'un rival", c.rouge));
	paquet.add(new Vangeance(3, "Défaussez l'Oeuvre Exposée d'un rival", c.rouge));
	paquet.add(new Vangeance(3, "Défaussez l'Oeuvre Exposée d'un rival", c.rouge));
	paquet.add(new Bassesse(3, "Défaussez au hasard 2 cartes de la Main d'un rival", c.rouge));
	paquet.add(new Bassesse(3, "Défaussez au hasard 2 cartes de la Main d'un rival", c.rouge));
	paquet.add(new  Mosaique("Embody","Choisissez une de vos Oeuvres. Copiez son pouvoir",c));
	paquet.add(new  Mosaique("Embody","Choisissez une de vos Oeuvres. Copiez son pouvoir",c));
	paquet.add(new  Mosaique("Embody","Choisissez une de vos Oeuvres. Copiez son pouvoir",c));
	paquet.add(new  Mosaique("Embody","Choisissez une de vos Oeuvres. Copiez son pouvoir",c));
	paquet.add(new  Mosaique("Embody","Choisissez une de vos Oeuvres. Copiez son pouvoir",c));
	paquet.add(new  Mosaique("Mimic","Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée",c));
	paquet.add(new  Mosaique("Mimic","Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée",c));
	
	
	
	
	// code du Listener lorsque la main est vide 
	
	
	addPropertyChangeListiner( new PropertyChangeListener() {

		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			// TODO Auto-generated method stub
		
		
			switch(evt.getPropertyName()) {
				
			case "m":
				ArrayList<String> newm = (ArrayList<String>) evt.getNewValue();
				
			
				if(newm.size()==0) {
					
					JOptionPane.showMessageDialog(null,"**votre main et pile sont vide**");
					 
					
					suivie.next_niveau(oeuvre);
					
					suivie.afficher_niveau();    //
					
					
					
					fausse.defausser();// Essayer de defausser ses oeuvres
					
					//Ajouter les cartes de la vie future pour constituer la main et ajouter le reste de carte
					
					int compte=0;
					
					Iterator<Carte> it = v.iterator();
					while(it.hasNext()) {
					m.add(it.next());
					compte++;
				    }
					
					compte=6-compte;
					source.distribuer(compte,p);
					
					v.clear();
					
					
					
					return;
				}
				break;
			
			case "m1":
				
                ArrayList<String> newm1 = (ArrayList<String>) evt.getNewValue();
				
			
				if(newm1.size()==0) {
					
					JOptionPane.showMessageDialog(null,"**votre main et pile sont vide**");
					
					
					suivie1.next_niveau(oeuvre1);
					suivie1.afficher_niveau();
					
					 
					fausse1.defausser();// Essayer de defausser ses oeuvres
					
					//Ajouter les cartes de la vie future pour constituer la main et ajouter le reste de carte
					
					int compte=0;
					
					Iterator<Carte> it = v1.iterator();
					while(it.hasNext()) {
					m1.add(it.next());
					compte++;
				    }
					
					compte=6-compte;
					source.distribuer(compte,p1);
					
					v1.clear();
					
					
					
					
					
					
					
					return;
				}
				break;
			
				} 
			}});
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	ArrayList<Carte> s = new ArrayList<Carte>();
	public Source source = new Source(paquet);
	
	

 	 
 	 public void distribuer() {
/**
 		  * permet a la source de distribuer les cartes
 		  * @author Richanel Mbou
          * @version 1.0
 		  */
 		source.distribuer(m, p);
 		source.distribuer(m1, p1);
 		
 for(int i=0; i<m.size();i++) {
			 
			 old_m.add(this.m.get(i));
		 } 
 
 for(int i=0; i<m1.size();i++) {
	 
	 old_m1.add(this.m1.get(i));
 } 
 
 for(int i=0; i<p.size();i++) {
	 
	 old_p.add(this.p.get(i));
 } 
 
 for(int i=0; i<p1.size();i++) {
	 
	 old_p1.add(this.p1.get(i));
 } 
 	
 	 }
 	 
 	 
 	 
 	 
 	 
 	 
 	 //Observable
 	 
 	 
 	private PropertyChangeSupport changement = new PropertyChangeSupport(this);
 	 
	  
	public void addPropertyChangeListiner(PropertyChangeListener listener) {
/**
		 * @author Richanel Mbou
         * @version 1.0
		 * Permet d'ajouter un Listener
		 */
		changement.addPropertyChangeListener(listener);
	}
	
	
 	 
   public void change() {
/**
		 * Permet de detecter les changements d'etats
		 * @author Richanel Mbou
         * @version 1.0
		 */
		changement.firePropertyChange("m",old_m,this.m);
		changement.firePropertyChange("m1",old_m1,this.m1);	
		
	 }
}
