package Karmaka;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Class representant les proprietes d'une carte ainsi que le code des differents pouvoir 
 * @author Richanel Mbou
 * @version 1.0
 */

public abstract class Carte {
	
	private String nomCarte;
	private int point_Carte;
	private String libelle_pouvoir;
	private Couleur couleur;
	
    private int id_p;
	
	public Carte(String nomCarte, int point_Carte, String libelle_pouvoir,Couleur couleur) {
		
		this.nomCarte = nomCarte;
		this.point_Carte = point_Carte;
		this.libelle_pouvoir = libelle_pouvoir;
		this.couleur=couleur;
	}



	public Couleur getCouleur() {
		return couleur;
	}


	public int getId_p() {
		return id_p;
	}



	public void setId_p(int id_p) {
		this.id_p = id_p;
	}



	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}








	public String getNomCarte() {
		return nomCarte;
	}








	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}








	public int getPoint_Carte() {
		return point_Carte;
	}








	public void setPoint_Carte(int point_Carte) {
		this.point_Carte = point_Carte;
	}








	public String getLibelle_pouvoir() {
		return libelle_pouvoir;
	}








	public void setLibelle_pouvoir(String libelle_pouvoir) {
		this.libelle_pouvoir = libelle_pouvoir;
	}


	
	
	Random random = new Random();
	
	
	
	



	public void jouerCapacite(ArrayList<Carte> v,Main main,Joueur j,ArrayList<Carte> m,ArrayList<Carte> m1,ArrayList<Carte> s,Oeuvre oeuvre,Vie_future vf,Pile pile,Pile pile1,ArrayList<Carte> v1,Fausse fausse,ArrayList<Carte> o1,ArrayList<Carte> f,ArrayList<Carte> p,ArrayList<Carte> p1,ArrayList<Carte> o) {
		
		// Les attributs sans 1 sont considerer comme les att du jouer qui fait l'action et les 
		
/**
		 * code des differents pouvoir selon le libelle du  pouvoir 
		 * 
		 * @parm
		 * @author Richanel Mbou
        * @version 1.0
		 */
		
		if(this.libelle_pouvoir=="Placez dans votre Main n'importe quelle carte de votre Vie Future.") {
			
			 
			if(! v.isEmpty()) {
			
		    int index_vf = Integer.parseInt(JOptionPane.showInputDialog("entrer la position de la carte dans la vie future"));
	      
		    main.ajouterCarte(v.get(index_vf));
	        v.remove(index_vf);
	        
	        JOptionPane.showMessageDialog(null,"Operation effectuee");
	        
			} else {   JOptionPane.showMessageDialog(null,"Votre vie future est vide");  }
	       
			id_p=1;
	        
			
		}else if(this.libelle_pouvoir=="Regardez la main d'un rival. Vous pouvez ensuite jouer une autre carte.") {
			 
			
				
				JOptionPane.showConfirmDialog(null,"\n ********La main du rival*******\n");
			     
				StringBuffer sb = new StringBuffer();
				
				 Iterator<Carte> it = m1.iterator(); // ici qu'on determine la main a afficher 
				 
			      
			      while(it.hasNext()) {
			    	  
			    	  Carte c =it.next();
			    	  
			    	  sb.append(c.getNomCarte()+"    "+c.getPoint_Carte()+"    "+c.getLibelle_pouvoir()+" "+c.getCouleur().name()+ "\n");
			    	 
			      }
			      
			      JOptionPane.showMessageDialog(null, sb.toString());
			      JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
			      
			      // jouer une carte de votre c'est sur le bouton pouvoir tu va coder le reste grace a l'id du pouvoir 
			      
			     // pas finir  // jouer une autre carte
				
			   id_p=2;
			
			
			
		}else if(this.libelle_pouvoir=="Regardez les 3 premières cartes de la  Source ;ajoutez-en jusqu'à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.") {
			
			
			JOptionPane.showMessageDialog(null,"------Les trois premieres carte de la Source-------");
			
			StringBuffer sb = new StringBuffer();
			
			for( int i=0; i<3;i++) {
				
				sb.append(s.get(i).getNomCarte()+"    "+s.get(i).getPoint_Carte()+"    "+s.get(i).getLibelle_pouvoir()+" "+s.get(i).getCouleur().name()+"\n");
			}
			
			   JOptionPane.showMessageDialog(null, sb.toString());
			
			
			// recuperer une valeur en interface graphique 
			   
			   
	try {
			   for(int i=0;i<2;i++) {
				   
				   String inputValue = JOptionPane.showInputDialog("Choisir une carte de la souce : ");
				   
				  if(inputValue != null) {
					  
			      vf.ajouterCarte(s.get(Integer.parseInt(inputValue)));
			      s.remove(Integer.parseInt(inputValue));
			      
				  }else {
					  
					  JOptionPane.showMessageDialog(null, "Valuer null");
				  }
			
			   }
			   
	}catch(NumberFormatException e) { JOptionPane.showMessageDialog(null, "echec de l'operation!!  la chaîne de caractères fournie ne peut pas être interprétée comme un nombre valide");}
			   
			   JOptionPane.showMessageDialog(null,"pouvoir effectuer");
			
			   id_p=3;
			   
		}else if(this.libelle_pouvoir=="Placez la première carte de la Vie Future d'un rival sur la votre.") {
			
			
		if(v1.size()>=1) {	
			
			 vf.ajouterCarte(v1.get(0));
			 v1.remove(0);
			 
			 JOptionPane.showMessageDialog(null,"pouvoir effectuer");
		}else { JOptionPane.showMessageDialog(null,"echec la pile du rival contient moins d'une carte");}
			 
			 id_p=21;
			
		}else if(this.libelle_pouvoir=="Défaussez une carte de votre Main. Copiez le pouvoir de cette carte.") {
			
			
			 String inputValue = JOptionPane.showInputDialog("Choisir la position de la carte a defausser dans la main : ");
			   
			fausse.defausser(m.get(Integer.parseInt(inputValue)-1));
			
			m.remove(Integer.parseInt(inputValue)-1);
			
			// je ne sais pas ce que veux dire copier le pouvoir pour l'instant
			
			 id_p=4;
				
			
		}else if(this.libelle_pouvoir=="Regardez 3 cartes de la Main d'un rival; ajoutez-en une à votre Main.") {
			
			
			
			
         JOptionPane.showMessageDialog(null,"------Les trois premieres carte de la Main de l'adversaire-------");
			
			StringBuffer sb = new StringBuffer();
			
			for( int i=0; i<3;i++) {
				
				sb.append(m1.get(i).getNomCarte()+"    "+m1.get(i).getPoint_Carte()+"    "+m1.get(i).getLibelle_pouvoir()+" "+m1.get(i).getCouleur().name()+"\n");
			}
			
			   JOptionPane.showMessageDialog(null, sb.toString());
			
			
			// recuperer une valeur en interface graphique 
			   
	
			 
				   
				  String inputValue = JOptionPane.showInputDialog("Choisir une carte de la main de l'adversaire: ");
				   
				  if(inputValue != null) {
					  
			      vf.ajouterCarte(m1.get(Integer.parseInt(inputValue)));
			      m1.remove(Integer.parseInt(inputValue));
			      
				  }else {
					  
					  JOptionPane.showMessageDialog(null, "Valuer null");
				  }
			
			   
			
			   id_p=5;
			
			
			
			
		}else if(this.libelle_pouvoir=="Placez dans votre Main l'Oeuvre Exposée d'un rival.") {
			
		
			if(!o1.isEmpty()) {
			main.ajouterCarte(o1.get(0));
			o1.remove(0);
			
			JOptionPane.showMessageDialog(null,"nous avons placez dans votre Main l'Oeuvre Exposée d'un rival.");
			}else {JOptionPane.showMessageDialog(null,"L'oeuvre du rival est vide");}
			 id_p=6;
				
			
		}else if(this.libelle_pouvoir=="Puisez une carte à la Source. Vous pouvez ensuite jouer une autre carte.") {
			
			int index = Math.abs(random.nextInt(s.size()));
			
			pile.ajouterCarte(s.get(index));
			s.remove(index);
			JOptionPane.showMessageDialog(null," Pouvoir effectuer ");
			
			// hum
			
			 id_p=7;
				
			
		}else if(this.libelle_pouvoir=="Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse.") {
			
			
			ArrayList<Carte> dernier3 = null;
			
			if(f.size() >= 3) {
			
			StringBuffer sb = new StringBuffer();
			sb.append(" Les 3 dernier carte de la fausse sont : \n");
			for(int i=0; i<3; i++) {
				
				
				dernier3.add(f.get(f.size()-i-1));
				
				sb.append(f.get(f.size()-i-1).getNomCarte()+"    "+f.get(f.size()-i-1).getPoint_Carte()+"    "+f.get(f.size()-i-1).getLibelle_pouvoir()+" "+f.get(f.size()-i-1).getCouleur().name()+"\n");
			
				
			}
			
			JOptionPane.showMessageDialog(null, sb.toString());
			
			String input = JOptionPane.showInputDialog("Choisir une des trois dernier carte : ");
			
			vf.ajouterCarte(dernier3.get( Integer.parseInt(input) -1));
			f.remove(dernier3.get( Integer.parseInt(input) -1));
			
			
			
			JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
			
			}else { JOptionPane.showMessageDialog(null,"La fosse est vide ");    }
			
			
			
			 id_p=8;
				
			
			
		}else if(this.libelle_pouvoir=="Ajoutez à votre Main une des 3 dernières cartes de la Fosse.") {
			
             ArrayList<Carte> dernier3 = new ArrayList<Carte>();
			
			if(f.size() >= 3) {
			
			StringBuffer sb = new StringBuffer();
			sb.append(" Les 3 dernier carte de la fausse sont : \n");
			for(int i=0; i<3; i++) {
				
				
				dernier3.add(f.get(f.size()-i-1));
				
				sb.append(f.get(f.size()-i-1).getNomCarte()+"    "+f.get(f.size()-i-1).getPoint_Carte()+"    "+f.get(f.size()-i-1).getLibelle_pouvoir()+" "+f.get(f.size()-i-1).getCouleur().name()+"\n");
			
				
			}
			
			JOptionPane.showMessageDialog(null, sb.toString());
			
			String input = JOptionPane.showInputDialog("Choisir une des trois dernier carte : ");
			
			main.ajouterCarte(dernier3.get( Integer.parseInt(input) -1));
			f.remove(dernier3.get( Integer.parseInt(input) -1));
			
			
			
			JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
			
			}else { JOptionPane.showMessageDialog(null,"La fosse est vide ");    }
			
			
			
			
			
			
			
			
			 id_p=9;
				
			
			 
			 
			 
			 
			 
			 
		}else if(this.libelle_pouvoir=="Placez 2 cartes puisées à la Source sur la Pile d'un Jouer.") {
			
			//ok
			
           for(int i=0; i<2; i++) {
        	   
        	   int index = Math.abs(random.nextInt(s.size()));
				
				pile1.ajouterCarte(s.get( index ));
				
			}
			
			JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
			
			 id_p=10;
				
			
		}else if(this.libelle_pouvoir=="Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main") {
			
			
			 for(int i=0; i<2; i++) {
				 
				 int index = Math.abs(random.nextInt(s.size()));
					
					pile.ajouterCarte(s.get(  index ));
					s.remove(index);
					
				}
			 
			 
			if(m.size()>=2) { 
			 for(int i=0; i<2; i++) {
					
				   String input = JOptionPane.showInputDialog("Choisir position carte dans votre main"); 
				 
					vf.ajouterCarte(m.get(Integer.parseInt(input)));
					
					m.remove(Integer.parseInt(input));
					
					JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
					
				}
			}else {
				
				JOptionPane.showMessageDialog(null, " votre main contient moins de 02 cartes");
				
			}
				
			
				
				 id_p=11;
					
				
			
		}else if(this.libelle_pouvoir=="Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre carte.") {
			
			
			
              for(int i=0; i<3; i++) {
            	  
            	  
            	  int index =Math.abs(random.nextInt(s.size()));
				
				pile.ajouterCarte(s.get(index));
            	  s.remove(index);
				
			}
              JOptionPane.showMessageDialog(null,"Pouvoir effectuee");
              // jouer une autre carte 
              
              
              id_p=12;
  			
		
		}else if(this.libelle_pouvoir=="Placez jusqu'à 2 cartes de votre Main sur vos Oeuvres.") {
			
				   
				   
				   for(int i=0;i<2;i++) {
					   
					   
					   String input = JOptionPane.showInputDialog("Choisir une carte de la main :");
			
				   
				      oeuvre.ajouterCarte(m.get(Integer.parseInt(input)-1));
				      
				      m.remove(Integer.parseInt(input)-1);
				   
			       }
			
			
			
				   id_p=13;
					
			
		}else if(this.libelle_pouvoir== "Défaussez la première carte de la Pile d'un jouer. Vous pouvez ensuite jouer une autre carte.") {
			
			//ok partellement
			
			if(!p1.isEmpty()) {
			
			fausse.defausser(p1.get(0));
			p1.remove(0);
			
			}else {JOptionPane.showMessageDialog(null, "La pile de l'adversaire est vide ");}
			
			JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
			
			// Jouer une carte apres  
			
			
			 id_p=14;
				
			
		}else if(this.libelle_pouvoir=="Le joueur de votre choix défausse une carte de sa Main.") {
			
			int index = Math.abs(random.nextInt(m.size()));
			
			fausse.defausser(m1.get(index));
			m1.remove(index);
			
			JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
			
			
			 id_p=15;
				
			
		}else if(this.libelle_pouvoir=="Le rival de votre choix défausse une de ses Oeuvres .") {
			
			
			if(o1.size()>=1) {
			
             int index= Math.abs(random.nextInt(o1.size()));
			
             fausse.defausser(o1.get( index));
			 o1.remove(index);
			 
			 JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
			}else {JOptionPane.showMessageDialog(null, "echec!! l'oeuvre du rival contient moins d'une carte");}
			
			 id_p=16;
				
			
		}else if(this.libelle_pouvoir=="Défaussez jusqu'à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1") {
			
			
			
			
		  for(int i =0; i<2; i++) {
			  
			  int  index = Integer.parseInt(JOptionPane.showInputDialog("Entrer la position de la carte dans la main: "));
			  fausse.defausser(m.get(index-1));
			  m.remove(index-1);  
			  
		  }
		  
		  int  nbre = Integer.parseInt(JOptionPane.showInputDialog("Entrer le nombre de carte a puisser dans la source: "));
		  
		  ////////////
		  
		  int  index = Math.abs(random.nextInt(s.size()));
		  
		  for(int i=0; i<nbre; i++) {
			
			pile.ajouterCarte(s.get(index));
        	  s.remove(index);
			
		}
          JOptionPane.showMessageDialog(null,"Pouvoir effectuee");
         
          
			
			
			
			
			
			
			 id_p=17;
				
			
			
		}else if(this.libelle_pouvoir=="Défaussez les 2 premières cartes de la Vie Future d'un rival") {
			
			
	if(v1.size()>=2) {		
          for(int i = 0; i<2;i++) {
			fausse.defausser(v1.get(i));
			v1.remove(i);
			
			
			
         }
			
			JOptionPane.showMessageDialog(null, "Done");
	}else { JOptionPane.showMessageDialog(null, "echec de l'operation!! la vie future de l'adversaire contient moins de deux carte "); }
			
			 id_p=18;
				
			
		}else if(this.libelle_pouvoir=="Défaussez l'Oeuvre Exposée d'un rival") {
			
			if(! o1.isEmpty()) {
			   int index = Math.abs(random.nextInt(o1.size()));
	         
				fausse.defausser(o1.get(index));
				o1.remove(index);
	         
				
				JOptionPane.showMessageDialog(null, "Pouvoir effectuee");
			}else { JOptionPane.showMessageDialog(null, "L'oeuvre du rival est vide");  }			
				 id_p=19;
					
			
		}else if(this.libelle_pouvoir=="Défaussez au hasard 2 cartes de la Main d'un rival") {
			
			for( int i=0 ; i<2; i++) {
				
				int index = Math.abs(random.nextInt(m1.size()));
			
			    fausse.defausser(m1.get(index));
			  
			    m1.remove(index);
				
			
			}
			
			JOptionPane.showMessageDialog(null, "Pouvoir effectuer");
			
			 id_p=20;
		}else if(this.libelle_pouvoir=="Choisissez une de vos Oeuvres. Copiez son pouvoir") {
			
			if(!o.isEmpty()) {
				
				int index = Integer.parseInt(JOptionPane.showInputDialog("Choisir la position de la carte dans vos oeuvre "));
				
				
				JOptionPane.showMessageDialog(null,"Pouvoir copie");
			}else {JOptionPane.showMessageDialog(null,"Votre oeuvre est vide !! ");}
			
			
			id_p=22;
		}else if(this.libelle_pouvoir=="Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée") {
			
			
          if(!o1.isEmpty()) {
				
				//l'oeuvre est la derniere carte dans la list
        	  
        	  JOptionPane.showMessageDialog(null,"Pouvoir copie");
			}else {JOptionPane.showMessageDialog(null,"L'oeuvre du rival est vide !! ");}   
			
			
			
			
			id_p=23;
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
