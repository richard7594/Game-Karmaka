package Karmaka;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Source extends Plateau {
/**
	 * Represente l'ensemble carte qui constitu la source 
	 * @author Richanel Mbou
 * @version 1.0
	 */
	
	public static int deja_distribuer=0;
	
	public ArrayList <Carte> s = new ArrayList <Carte> ();
	
	Random random = new Random();
	 

	public Source(ArrayList<Carte> s) {
		super(s);
		this.s = s;
	}
	
	
	


	//fonctionne
	public void distribuer(ArrayList<Carte> m,ArrayList<Carte> p ) {
/*
	 * Permet de distribuer les carrtes constituant la source
	 */
	if(deja_distribuer==0 || deja_distribuer==1) {//if Pour dire qu'on distribut slmt les deuc premier fois au deux joueur 
		
		 deja_distribuer++;
		for(int j=0;j<4;j++) {
			
		int index = Math.abs(random.nextInt(s.size())) ; // tu doit mettre le nombre de carte au total
		
		Carte c	= s.get(index);
		
	       if(!m.contains(c)){
		   
	    	  m.add(c); 
	    	   
	       }
	       s.remove(index);}
		
		
		for(int j=0;j<2;j++) {
			
			
			int index = Math.abs(random.nextInt(s.size())); // tu doit mettre le nombre de carte au total // J'AI add abs
			
			Carte c	= s.get(index);
			
		       if(!p.contains(c)){
			   
		    	  p.add(c); 
		    	   
		       }
		       s.remove(index);
		       
		      
			}}}
	
	
	//Surchage de la methode
	
	public void distribuer(int compte,ArrayList<Carte> p  ) {
/**
		 * Surchage
		 * @author Richanel Mbou
 * @version 1.0
		 */
         for(int j=0;j<compte;j++) {
			
			
			int index = random.nextInt(s.size()) ; // tu doit mettre le nombre de carte au total
			
			Carte c	= s.get(index);
			
		       if(!p.contains(c)){
			   
		    	  p.add(c); 
		    	   
		       }
		       s.remove(index);
		       
		
	}}
	
	@Override
	public void ajouterCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void piocherCarte(Carte c) {
		// TODO Auto-generated method stub
		
	}

	
//afficher source
	
public void affichS() {
		
		System.out.println("------Source-------");
		for( int i=0; i<carte.size();i++) {
			
			System.out.println(carte.get(i).getNomCarte()+"    "+carte.get(i).getPoint_Carte()+"    "+carte.get(i).getLibelle_pouvoir()+" "+carte.get(i).getCouleur().name());
		}
		
	}

		
	
	
	
	
	

}
