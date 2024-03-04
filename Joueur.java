package Karmaka;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Joueur {

/**
	 * Classe representant un joueur 
	 * @author Richanel Mbou
	 * @version 1.0
	 */
	
	
	private String nom;
	private String prenom;
	private static int id_joueur;
	
	// pour un constructeur d'auto incrementation
	
	private static int compteur=0;
	
	
public Joueur(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		
		compteur++;
		this.id_joueur = compteur;
	}






public String getNom() {
	return nom;
}






public void setNom(String nom) {
	this.nom = nom;
}






public String getPrenom() {
	return prenom;
}






public void setPrenom(String prenom) {
	this.prenom = prenom;
}






public int getId_joueur() {
	return id_joueur;
}






public void setId_joueur(int id_joueur) {
	this.id_joueur = id_joueur;
}


public void JouerCarte() {
		
		
	}
public void PiocherCarte() {
	
	
}



// Jouer une Oeuvre ou pas  peut pouvoir 
public void PriseDecisionO (Oeuvre oeuvre,ArrayList<Carte> m,Main main,ArrayList<Carte> p,int index_main,int index_pile) {

	
/**
 * permet au joueur de choisir  une carte pour la jouer pour ses points 
 * @author Richanel Mbou
 * @version 1.0 
 *
 */
	   if( p.isEmpty()!=true) { 
		
        main.ajouterCarte(p.get(index_pile));
        p.remove(index_pile);
		 
        
        oeuvre.ajouterCarte(m.get(index_main)); // -1 parceque tu dis 1 ou 2
        m.remove(index_main);
        
	}else {
	
        
        oeuvre.ajouterCarte(m.get(index_main)); // -1 parceque tu dis 1 ou 2
        m.remove(index_main);
       
	
	}

}

//  Prise decision vie future

public void PriseDecisionVF(Vie_future vf,ArrayList<Carte> m,Main main,ArrayList<Carte> p,int index_main,int index_pile ) {
	   
	
/**
 * permet au joueur de choisir  une carte pour la jouer pour sa vie future 
 *@author Richanel Mbou
 * @version 1.0 
 
 */
	
	if( p.isEmpty()!=true) { 
		
		 	 
        main.ajouterCarte(p.get(index_pile));
        p.remove(index_pile);
		
        vf.ajouterCarte(m.get(index_main));
        m.remove(index_main);
	}else {
		
		 vf.ajouterCarte(m.get(index_main));
	     m.remove(index_main);
	}
    
    
    }

	   


	// Toute c'est methode concerne les pouvoir    
	   
public void PriseDecision_1_action_O (Oeuvre oeuvre,ArrayList<Carte> m,int index_main) {
	
     
     oeuvre.ajouterCarte(m.get(index_main)); // -1 parceque tu dis 1 ou 2
     m.remove(index_main);
  

}

//Prise decision vie future

public void PriseDecision_1_action_VF(Vie_future vf,ArrayList<Carte> m,int index_main ) {
	
/**
 * permet au joueur de choisir  une carte pour la jouer pour sa vie future  
 *@author Richanel Mbou
 * @version 1.0
 * 
 */
		
		 vf.ajouterCarte(m.get(index_main));
	     m.remove(index_main);
 
}
	   
	   
   
	
	
}