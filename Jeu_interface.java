package Interface_graphique_MVC;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Karmaka.Carte;
import Karmaka.Fausse;
import Karmaka.Joueur;
import Karmaka.Main;
import Karmaka.Partie;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JToolBar;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLayeredPane;

public class Jeu_interface extends JFrame  {
	
/**
	 * Interface graphique du jeux 
	 * @author Richanel Mbou
	
 * @version 1.0
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	
	
	private JTable main;
	private JTable oeuvre;
	private JTable vie_future;
	private JTable pile;
	
	public static int chge=1;
	
	Partie game = new Partie();
	
	ArrayList<String> nomA = new ArrayList<String>();
	ArrayList<String> prenomA = new ArrayList<String>();
	
	private String nomj;
	private String prenomj;
	private Joueur j1;    // Ici il y a le joueur
	private Joueur j2;
 
   private static int nbrej =0;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jeu_interface frame = new Jeu_interface();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	
	
	/**
	 * Create the frame.
	 */
	public Jeu_interface() {
		
		
		
		// Code interface 
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//
		JPanel joueur1 = new JPanel();
		joueur1.setBounds(0, 0, 900, 750);
		contentPane.add(joueur1);
		

		JPanel plateau_interface = new JPanel();
		plateau_interface .setBounds(0, -1, 900, 750);
		contentPane.add(plateau_interface );
		
		
		joueur1.setLayout(null);
		joueur1.setLayout(null);
		
		JLabel point_k = new JLabel("");
		point_k.setBounds(829, 284, 46, 14);
		plateau_interface.add(point_k);
		
		
		
		JButton btnNewButton = new JButton("valider");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				nbrej++;
				
	         	nomA.add(nom.getText());
				prenomA.add(prenom.getText());
				
				JOptionPane.showMessageDialog(null,"Vous avez enregistrer "+nbrej +" joueur(s)");
			
			}
		});
		
		//
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(278, 248, 89, 23);
		joueur1.add(btnNewButton);
		
		nom = new JTextField();
		nom.setBounds(209, 48, 213, 20);
		joueur1.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(209, 91, 213, 20);
		joueur1.add(prenom);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(82, 51, 46, 14);
		joueur1.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(82, 94, 46, 14);
		joueur1.add(lblPrenom);
		
		JButton next = new JButton("next");
		next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				joueur1.setVisible(false);
				plateau_interface.setVisible(true);
			    
				
			}
		});
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		next.setBounds(399, 248, 89, 23);
		joueur1.add(next);
		
		
		
		
		
		// Code du plateau
		
		////////////////////////////////////////////////////////////
	
		
		
		    
		/**
		 * Create the panel.
		 */
		
			getContentPane().setLayout(null);
			plateau_interface.setLayout(null);
			
			Label label_1 = new Label("");
			label_1.setBounds(26, 31, 200, 22);
			plateau_interface.add(label_1);
	        
			JScrollPane scroll = new JScrollPane();
			scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll.setBounds(564, 421, 220, 100);
			plateau_interface.add(scroll);
			
			
			JTextArea textArea = new JTextArea();
			textArea.setBounds(564, 421, 220, 100);
			plateau_interface.add(textArea);
			scroll.getViewport().add(textArea);   
			
			
			
			JLabel photo = new JLabel("");		
			photo.setBounds(564, 88, 220, 310);
			plateau_interface.add(photo);
			
			
			
	        
			main = new JTable();
			main.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int ligne = main.getSelectedRow();
					//int column =main.getSelectedColumn();
					String a = main.getModel().getValueAt(ligne,0).toString();// zero represente la colonne;
					
					
				if(chge%2 !=0) {	
					
					Iterator<Carte> it  = game.m.iterator() ;
					while(it.hasNext()) {
						
						Carte c = it.next();
						
						if(c.getNomCarte()==a) {
							
							textArea.setText(c.getLibelle_pouvoir());
						}
						
					}}else {
						
						Iterator<Carte> it  = game.m1.iterator() ;
						while(it.hasNext()) {
							
							Carte c = it.next();
							
							if(c.getNomCarte()==a) {
								
								textArea.setText(c.getLibelle_pouvoir());
							}
						
						
					}}
					
					
					// on n'a pas faire la carte jubilee
					
					if(a=="Destiny") {
						
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Destiny.png"));
						
					}else if (a=="Crisis") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Crisis.png"));
					}else if (a=="Thievery") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Thievery.png"));
					}else if (a=="Denial") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Denial.png"));
					}else if (a=="Dwindle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Dwindle.png"));
					}else if (a=="Embody") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Embody.png"));
					}else if (a=="Longevity") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Longetivity.png"));
					}else if (a=="Mimic") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Mimic.png"));
					}else if (a=="Peek") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\peek.png"));
					}else if (a=="Recycle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Recycle.png"));
					}else if (a=="Roulette") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Roulette.png"));
					}else if (a=="Salvage") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Salvage.png"));
					}else if (a=="Sowing") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Sowing.png"));
					}else if (a=="Bassesse") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Spite.png"));
					}else if (a=="Swindle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Swindle.png"));
					}else if (a=="Transmigration") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Transmigrate.png"));
					}else if (a=="Vengeance") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Vengeance.png"));
					}else if (a=="Voyage") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Voyage.png"));
					}else if (a=="Another Day") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\AnotherDay.png"));
					}else if (a=="Stolen Dreams") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Stolen Dream.png"));
					}else if (a=="Fournaise") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Hell_s Heart.png"));
					}else if (a=="Vangeance") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Vengeance.png"));
					}else if (a=="Panic") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Panic.jpg"));
					}else if(a=="Jubilee") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Jubilee.jpg"));
						
					}
					
					
					//JOptionPane.showMessageDialog(null, a);
					
					
					
				}
			});
			main.setBounds(26, 88, 180,160);
			plateau_interface.add(main);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(26, 88, 180,160);
			plateau_interface.add(scrollPane);
		
			
			
			
			Label label = new Label("START");
			label.setBackground(new Color(0, 191, 255));
			label.setBounds(400, 31, 48, 22);
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					distribution();
					AfficheMain_pile();
					
					label_1.setText("Joueur en cour: "+nomA.get(0)+"  "+prenomA.get(0));
					
				}
			});
			plateau_interface.add(label);
			
			
		
			oeuvre = new JTable();
			oeuvre.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					

					int ligne = oeuvre.getSelectedRow();
					//int column =main.getSelectedColumn();
					String a = oeuvre.getModel().getValueAt(ligne,0).toString();// zero represente la colonne;
					

					if(chge%2 !=0) {	
						
						Iterator<Carte> it  = game.o.iterator() ;
						while(it.hasNext()) {
							
							Carte c = it.next();
							
							if(c.getNomCarte()==a) {
								
								textArea.setText(c.getLibelle_pouvoir());
							}
							
						}}else {
							
							Iterator<Carte> it  = game.o1.iterator() ;
							while(it.hasNext()) {
								
								Carte c = it.next();
								
								if(c.getNomCarte()==a) {
									
									textArea.setText(c.getLibelle_pouvoir());
								}
							
							
						}}
						
					
					
				   
					
					// on n'a pas faire la carte jubilee
					
					if(a=="Destiny") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Destiny.png"));
						
					}else if (a=="Crisis") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Crisis.png"));
					}else if (a=="Thievery") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Thievery.png"));
					}else if (a=="Denial") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Denial.png"));
					}else if (a=="Dwindle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Dwindle.png"));
					}else if (a=="Embody") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Embody.png"));
					}else if (a=="Longevity") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Longetivity.png"));
					}else if (a=="Mimic") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Mimic.png"));
					}else if (a=="Peek") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\peek.png"));
					}else if (a=="Recycle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Recycle.png"));
					}else if (a=="Roulette") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Roulette.png"));
					}else if (a=="Salvage") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Salvage.png"));
					}else if (a=="Sowing") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Sowing.png"));
					}else if (a=="Bassesse") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Spite.png"));
					}else if (a=="Swindle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Swindle.png"));
					}else if (a=="Transmigration") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Transmigrate.png"));
					}else if (a=="Vengeance") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Vengeance.png"));
					}else if (a=="Voyage") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Voyage.png"));
					}else if (a=="Another Day") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\AnotherDay.png"));
					}else if (a=="Stolen Dreams") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Stolen Dream.png"));
					}else if (a=="Fournaise") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Hell_s Heart.png"));
					}else if (a=="Vangeance") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Vengeance.png"));
					}else if (a=="Panic") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Panic.jpg"));
					}else if(a=="Jubilee") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Jubilee.jpg"));
						
					}
					
				}
			});
			oeuvre.setBounds(269, 300, 180,160);
			plateau_interface.add(oeuvre);

			JScrollPane scrollPane_oeuvre= new JScrollPane();
			scrollPane_oeuvre.setBounds(269, 300, 180,160);
			plateau_interface.add(scrollPane_oeuvre);
			
			
			
			vie_future = new JTable();
			vie_future.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					

					int ligne = vie_future.getSelectedRow();
					//int column =main.getSelectedColumn();
					String a = vie_future.getModel().getValueAt(ligne,0).toString();// zero represente la colonne;
					

					if(chge%2 !=0) {	
						
						Iterator<Carte> it  = game.v.iterator() ;
						while(it.hasNext()) {
							
							Carte c = it.next();
							
							if(c.getNomCarte()==a) {
								
								textArea.setText(c.getLibelle_pouvoir());
							}
							
						}}else {
							
							Iterator<Carte> it  = game.v1.iterator() ;
							while(it.hasNext()) {
								
								Carte c = it.next();
								
								if(c.getNomCarte()==a) {
									
									textArea.setText(c.getLibelle_pouvoir());
								}
							
							
						}}
					
				   
					
					
					// on n'a pas faire la carte jubilee
					
					if(a=="Destiny") {
						
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Destiny.png"));
						
					}else if (a=="Crisis") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Crisis.png"));
					}else if (a=="Thievery") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Thievery.png"));
					}else if (a=="Denial") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Denial.png"));
					}else if (a=="Dwindle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Dwindle.png"));
					}else if (a=="Embody") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Embody.png"));
					}else if (a=="Longevity") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Longetivity.png"));
					}else if (a=="Mimic") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Mimic.png"));
					}else if (a=="Peek") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\peek.png"));
					}else if (a=="Recycle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Recycle.png"));
					}else if (a=="Roulette") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Roulette.png"));
					}else if (a=="Salvage") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Salvage.png"));
					}else if (a=="Sowing") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Sowing.png"));
					}else if (a=="Bassesse") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Spite.png"));
					}else if (a=="Swindle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Swindle.png"));
					}else if (a=="Transmigration") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Transmigrate.png"));
					}else if (a=="Vengeance") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Vengeance.png"));
					}else if (a=="Voyage") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Voyage.png"));
					}else if (a=="Another Day") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\AnotherDay.png"));
					}else if (a=="Stolen Dreams") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Stolen Dream.png"));
					}else if (a=="Fournaise") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Hell_s Heart.png"));
					}else if (a=="Vangeance") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Vengeance.png"));
					}else if (a=="Panic") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Panic.jpg"));
					}else if(a=="Jubilee") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Jubilee.jpg"));
						
					}
					
				}
			});
			vie_future.setBounds(26, 300, 180,160);
			plateau_interface.add(vie_future);
			JScrollPane scrollPane_vf = new JScrollPane();
			scrollPane_vf.setBounds(26, 300, 180,160);
			plateau_interface.add(scrollPane_vf);
			
			

			
			
			pile = new JTable();
			pile.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					
					
					int ligne = pile.getSelectedRow();
					//int column =main.getSelectedColumn();
					String a = pile.getModel().getValueAt(ligne,0).toString();// zero represente la colonne;
					

					if(chge%2 !=0) {	
						
						Iterator<Carte> it  = game.p.iterator() ;
						while(it.hasNext()) {
							
							Carte c = it.next();
							
							if(c.getNomCarte()==a) {
								
								textArea.setText(c.getLibelle_pouvoir());
							}
							
						}}else {
							
							Iterator<Carte> it  = game.p1.iterator() ;
							while(it.hasNext()) {
								
								Carte c = it.next();
								
								if(c.getNomCarte()==a) {
									
									textArea.setText(c.getLibelle_pouvoir());
								}
							
							
						}}
				   
					
					
					// on n'a pas faire la carte jubilee
					
					if(a=="Destiny") {
						
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Destiny.png"));
						
					}else if (a=="Crisis") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Crisis.png"));
					}else if (a=="Thievery") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Thievery.png"));
					}else if (a=="Denial") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Denial.png"));
					}else if (a=="Dwindle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Dwindle.png"));
					}else if (a=="Embody") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Embody.png"));
					}else if (a=="Longevity") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Longetivity.png"));
					}else if (a=="Mimic") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Mimic.png"));
					}else if (a=="Peek") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\peek.png"));
					}else if (a=="Recycle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Recycle.png"));
					}else if (a=="Roulette") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Roulette.png"));
					}else if (a=="Salvage") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Salvage.png"));
					}else if (a=="Sowing") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Sowing.png"));
					}else if (a=="Bassesse") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Spite.png"));
					}else if (a=="Swindle") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Swindle.png"));
					}else if (a=="Transmigration") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Transmigrate.png"));
					}else if (a=="Vengeance") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Vengeance.png"));
					}else if (a=="Voyage") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Voyage.png"));
					}else if (a=="Another Day") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\AnotherDay.png"));
					}else if (a=="Stolen Dreams") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Stolen Dream.png"));
					}else if (a=="Fournaise") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Hell_s Heart.png"));
					}else if (a=="Vangeance") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Vengeance.png"));
					}else if (a=="Panic") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Panic.jpg"));
					}else if(a=="Jubilee") {
						photo.setIcon(new ImageIcon("C:\\Users\\USER\\eclipse-workspace\\Karmaka\\Img_carte\\Jubilee.jpg"));
						
					}
					
					
					
					
					
					
				}
			});
			pile.setBounds(269, 88,180,160);
			plateau_interface.add(pile);

			JScrollPane scrollPane_pile = new JScrollPane();
			scrollPane_pile.setBounds(269, 88, 180,160);
			plateau_interface.add(scrollPane_pile);
			
			
			JButton btnNewButton_1 = new JButton("Vie Future");
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					j1=new Joueur(nomA.get(0),prenomA.get(0));
					j2= new Joueur(nomA.get(1),prenomA.get(1));
					
					
				try {
					int index_main = main.getSelectedRow();
					int index_pile= pile.getSelectedRow();
					
					
					if(chge%2!=0 ) {
					j1.PriseDecisionVF(game.vf,game.m,game.main,game.p,index_main, index_pile);
					
					     Vie_future();  // on affiche l'operation
						AfficheMain_pile();	
				
					game.change(); // detecte les changements
					
					// on  affiche pour le second
					
					
					AfficheMain_pile1();
					Vie_future1() ;
					Oeuvre1();
					label_1.setText("Joueur en cour:  "+j2.getNom()+"  "+j2.getPrenom());
					point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
					chge++;
					}else {
						
						j2.PriseDecisionVF(game.vf1,game.m1,game.main1,game.p1,index_main, index_pile);
						
						Vie_future1();// on affiche l'operation
						AfficheMain_pile1();	
						
						game.change(); // detecte les changements
						
						//on affiche les info du premier
						
						AfficheMain_pile();
						Vie_future();
						Oeuvre();
						label_1.setText("Joueur en cour:  "+j1.getNom()+"  "+j1.getPrenom());
						point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
						chge++;
						
						
					}
							
					
				} catch ( IndexOutOfBoundsException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Veuiller piocher d'abord une carte dans pile ou dans la main");}	
					
				}
			});
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			btnNewButton_1.setBounds(158, 500, 90, 23);
			plateau_interface.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Passer votre tour");
			btnNewButton_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					try {

					j1=new Joueur(nomA.get(0),prenomA.get(0));
					j2= new Joueur(nomA.get(1),prenomA.get(1));
					
					
					
					if(chge%2!=0 ) {
						
					if(! game.p.isEmpty()) {
						// on affihe pour le 2eme quittant du 1er
						label_1.setText("Joueur en cour:  "+j2.getNom()+"  "+j2.getPrenom());
						
						
					Oeuvre1();
					AfficheMain_pile1();
					Vie_future1();
					point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
					chge++;
					}else{JOptionPane.showMessageDialog(null, " Desole votre pile ne contient pas des cartes"); }
					
					
					
					}else {
						
						
						if(! game.p1.isEmpty()) {
						label_1.setText("Joueur en cour:  "+j1.getNom()+"  "+j1.getPrenom());
						
						Oeuvre();
						AfficheMain_pile();
						Vie_future();
						point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
						chge++;
						}else{JOptionPane.showMessageDialog(null, " Desole votre pile ne contient pas des cartes"); }
					}
					
					
					
					} catch ( IndexOutOfBoundsException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Veuiller piocher d'abord une carte dans pile ou dans la main");}	
				
				}
				
				
			});
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_2.setBounds(368,500,117, 23);
			plateau_interface.add(btnNewButton_2);
			
			
			
			
			JButton btnNewButton_3 = new JButton("Oeuvre");
			btnNewButton_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e)   {
				
					
					
				try {
					
					
					int index_main = main.getSelectedRow();
					int index_pile= pile.getSelectedRow();
					
					j1=new Joueur(nomA.get(0),prenomA.get(0));
					j2= new Joueur(nomA.get(1),prenomA.get(1));
					
					
				   /* Oeuvre();
					AfficheMain_pile();*/	
						
					if(chge%2!=0 ) {
								
					j1.PriseDecisionO(game.oeuvre, game.m, game.main,game.p, index_main,index_pile);
					
					    Oeuvre(); // on affiche l'operation
						AfficheMain_pile();	
						
						
					    
					
						game.change(); // detecte les changements
					
						// on affiche pour le 2eme joueur
					Oeuvre1();
					AfficheMain_pile1();
					Vie_future1();
					point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
					label_1.setText("Joueur en cour: "+j2.getNom()+"  "+j2.getPrenom());
					
					
					chge++;
					}else {
						
						j2.PriseDecisionO(game.oeuvre1, game.m1, game.main1,game.p1, index_main,index_pile);
						
						 Oeuvre1();// on affiche l'operation
						AfficheMain_pile1();	
				
						game.change();
						
						// on affiche pour le 1 ere joueur
						Oeuvre();
						AfficheMain_pile();
						Vie_future();	
						label_1.setText("Joueur en cour: "+j1.getNom()+"  "+j1.getPrenom());
						point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
						chge++;
					}
					
					
					
					
					
				} catch ( IndexOutOfBoundsException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Veuiller piocher d'abord une carte dans pile ou dans la main");
				}	
			
					
				}
			});
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			
			btnNewButton_3.setBounds(50, 500, 90, 23);
			plateau_interface.add(btnNewButton_3);
			
			JButton btnNewButton_1_1 = new JButton("Pouvoir");
			btnNewButton_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					
					
					
					
				
					//on jour le pouvoir des carte de le mains
					
					int index_vf= pile.getSelectedRow();
				    int index_main = main.getSelectedRow();
				    int index_pile = pile.getSelectedRow();
				    
				  
				    
				  try {
					  
				  
				    if(chge%2 != 0) {
				    
				   
				    game.main.ajouterCarte(game.p.get(index_pile));	
				    game.p.remove(index_pile);
				    
				    pouvoirj1( index_main, label_1, point_k,index_vf);
				    
				   
					
				    }else {
				    	
				    	game.main1.ajouterCarte(game.p1.get(index_pile));	
					    game.p1.remove(index_pile);
				    	pouvoirj2( index_main, label_1, point_k,index_vf);
				    }
				
					
				  } catch ( IndexOutOfBoundsException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Veuiller piocher d'abord une carte dans pile ou dans la main");}	
					
					
					
					
							
					
				}});
			btnNewButton_1_1.setBounds(269, 500, 90, 23);
			plateau_interface.add(btnNewButton_1_1);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0));
			panel.setBounds(400, 31, 48, 22);
			plateau_interface.add(panel);
			
			// code niveau
			
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					if (chge%2!=0 ) {
						
						game.suivie.afficher_niveau();
						
						
					}else {
						
						game.suivie1.afficher_niveau();

					}	
					
					
					
				}
			});
			panel_1.setBackground(new Color(0, 191, 255));
			panel_1.setBounds(827, 159, 48, 22);
			plateau_interface.add(panel_1);
			
			JLabel lblNewLabel_1 = new JLabel("Niveau");
			panel_1.add(lblNewLabel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					label_1.setText("Joueur en cour:"+nomA.get(0)+"  "+prenomA.get(0));
					try {

					j1=new Joueur(nomA.get(0),prenomA.get(0));
					j2= new Joueur(nomA.get(1),prenomA.get(1));
					
					
					
					if(chge%2!=0 ) {
						// on affihe pour le 2eme quittant du 1er
						label_1.setText("Joueur en cour:  "+j2.getNom()+"  "+j2.getPrenom());
						
						
					Oeuvre1();
					AfficheMain_pile1();
					Vie_future1();
					point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
					chge++;
					}else {
						
						label_1.setText("Joueur en cour:  "+j1.getNom()+"  "+j1.getPrenom());
						
						Oeuvre();
						AfficheMain_pile();
						Vie_future();
						point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
						chge++;
					}
					
					} catch ( IndexOutOfBoundsException e2) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Veuiller piocher d'abord une carte dans pile ou dans la main");}	
				
					
					}
			});
			panel_2.setBackground(new Color(0, 191, 255));
			panel_2.setBounds(827, 208, 48, 22);
			plateau_interface.add(panel_2);
			
			JLabel lblNewLabel_1_1 = new JLabel("Switch");
			panel_2.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_2 = new JLabel("Main");
			lblNewLabel_2.setBounds(94, 259, 46, 14);
			plateau_interface.add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("Vie future");
			lblNewLabel_2_1.setBounds(94, 471, 100, 14);
			plateau_interface.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_2_2 = new JLabel("Pile");
			lblNewLabel_2_2.setBounds(339, 259, 46, 14);
			plateau_interface.add(lblNewLabel_2_2);
			
			JLabel lblNewLabel_2_3 = new JLabel("Oeuvre");
			lblNewLabel_2_3.setBounds(339, 471, 46, 14);
			plateau_interface.add(lblNewLabel_2_3);
			
			JLabel lblNewLabel_3 = new JLabel("Anneau");
			lblNewLabel_3.setBounds(829, 259, 70, 14);
			plateau_interface.add(lblNewLabel_3);
			
			
			
			JLabel lblNewLabel_4 = new JLabel("clear");
			lblNewLabel_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
							
						
						j1=new Joueur(nomA.get(0),prenomA.get(0));
						j2= new Joueur(nomA.get(1),prenomA.get(1));
						
					
						if(chge%2!=0 ) {
									
					
						
							// on affiche pour le 1eme joueur
						Oeuvre();
						AfficheMain_pile();
						Vie_future();
						point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
						label_1.setText("Joueur en cour: "+j1.getNom()+"  "+j1.getPrenom());
						photo.setIcon(null);
						
						
						}else {
							
							
							
							// on affiche pour le 2 ere joueur
							Oeuvre1();
							AfficheMain_pile1();
							Vie_future1();	
							label_1.setText("Joueur en cour: "+j2.getNom()+"  "+j2.getPrenom());
							point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
							photo.setIcon(null);
						}
						
					
					
					
				}
			});
			lblNewLabel_4.setBounds(829, 507, 46, 14);
			plateau_interface.add(lblNewLabel_4);
			
		
			
			
		
	
		
			
			scrollPane_pile.setViewportView(pile);
			scrollPane_vf.setViewportView(vie_future);
			scrollPane_oeuvre.setViewportView(oeuvre);
			 scrollPane .setViewportView(main);
			
	 	}
	
	
	


public void pouvoirj1(int index_main,Label label_1,JLabel point_k,int index_vf) {
	
	
	j1=new Joueur(nomA.get(0),prenomA.get(0));
	j2= new Joueur(nomA.get(1),prenomA.get(1));
	
	//if(chge%2 != 0) 
		
		game.m.get(index_main).jouerCapacite( game.v, game.main,j1 , game.m, game.m1,game.source.s, game.oeuvre, game.vf, game.pile, game.pile1, game.v1, game.fausse,game.o1, game.f, game.p,game.p1,game.o) ;
		
		//optionel test
		
		System.out.println("\n"+game.m.get(index_main).getId_p());
		
		
		if ( game.m.get(index_main).getId_p()==2 || game.m.get(index_main).getId_p()==14 || game.m.get(index_main).getId_p()==7 || game.m.get(index_main).getId_p()== 12 ) {
			
			int choix = JOptionPane.showConfirmDialog(null," Voulez vous jouer une autre carte ?");
			
			if(choix == 0) {
				
				Oeuvre();
				AfficheMain_pile();
				Vie_future();	
				label_1.setText("Joueur en cour: "+j1.getNom()+"  "+j1.getPrenom());
				point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
				
					
			}else {
				
				// affiche le deuxieme joeur
				Oeuvre1();
				AfficheMain_pile1();
				Vie_future1();	
				label_1.setText("Joueur en cour: "+j2.getNom()+"  "+j2.getPrenom());
				point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
				
				
				voulez_vous_carte(game.main1,game.m.get(index_main),game.fausse,game.m);
				
				Oeuvre1();
				AfficheMain_pile1();
				Vie_future1();	
				label_1.setText("Joueur en cour: "+j2.getNom()+"  "+j2.getPrenom());
				point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
				
				
				
				
				chge++;
				
			}
			
			
		}else {
			
			
			// affiche le deuxieme joeur
			Oeuvre1();
			AfficheMain_pile1();
			Vie_future1();	
			label_1.setText("Joueur en cour: "+j2.getNom()+"  "+j2.getPrenom());
			point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
			
			
			voulez_vous_carte(game.main1,game.m.get(index_main),game.fausse,game.m);
			
			Oeuvre1();
			AfficheMain_pile1();
			Vie_future1();	
			label_1.setText("Joueur en cour: "+j2.getNom()+"  "+j2.getPrenom());
			point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
			chge++;
			
			
			
		}
		
	}
		
		
		
public void pouvoirj2(int index_main,Label label_1,JLabel point_k,int index_vf) {		
		
			
	j1=new Joueur(nomA.get(0),prenomA.get(0));
	j2= new Joueur(nomA.get(1),prenomA.get(1));
	
	
	 game.m1.get(index_main).jouerCapacite( game.v1, game.main1,j2 , game.m1, game.m,game.source.s, game.oeuvre1, game.vf1, game.pile1, game.pile, game.v, game.fausse1,game.o, game.f, game.p1,game.p,game.o1) ;
		
		System.out.println("\n"+game.m1.get(index_main).getId_p());
		
		
        if ( game.m1.get(index_main).getId_p()==2 || game.m1.get(index_main).getId_p()==14 || game.m1.get(index_main).getId_p()==7 || game.m1.get(index_main).getId_p()== 12 ) {
			
			int choix = JOptionPane.showConfirmDialog(null," Voulez vous jouer une autre carte ?");
			
			if(choix == 0) {
				
				Oeuvre1();
				AfficheMain_pile1();
				Vie_future1();	
				label_1.setText("Joueur en cour: "+j2.getNom()+"  "+j2.getPrenom());
				point_k.setText(String.valueOf(game.suivie1.getPoint_Karmique()));
				
					
			}else {
				
				// affiche le 1er joeur
				Oeuvre();
				AfficheMain_pile();
				Vie_future();	
				label_1.setText("Joueur en cour: "+j1.getNom()+"  "+j1.getPrenom());
				point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
				
				
				voulez_vous_carte(game.main,game.m1.get(index_main),game.fausse,game.m1);
				
				Oeuvre();
				AfficheMain_pile();
				Vie_future();	
				label_1.setText("Joueur en cour: "+j1.getNom()+"  "+j1.getPrenom());
				point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
				
						
				chge++;
				
			}
			
			
		}else {
			
			
			// affiche le 1er joeur
			Oeuvre();
			AfficheMain_pile();
			Vie_future();	
			label_1.setText("Joueur en cour: "+j1.getNom()+"  "+j1.getPrenom());
			point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
			
			
			voulez_vous_carte(game.main,game.m1.get(index_main),game.fausse,game.m1);
			
			Oeuvre();
			AfficheMain_pile();
			Vie_future();	
			label_1.setText("Joueur en cour: "+j1.getNom()+"  "+j1.getPrenom());
			point_k.setText(String.valueOf(game.suivie.getPoint_Karmique()));
			chge++;
			
			
			
		}}
		
		
			
	
	
	
		
	
	
	
	

	public void voulez_vous_carte(Main main,Carte c,Fausse fausse,ArrayList<Carte> m1) {
		
		int choice = JOptionPane.showConfirmDialog(null," voulez vous la carte dont le rival vient de jouer le pouvoir?");
		
		if(choice==0) {
			
			main.ajouterCarte(c);
			m1.remove(c);
			
		}else {
			
			fausse.defausser(c);
			m1.remove(c);
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	  public void distribution() {

			game.distribuer();
			
			
	    	
	    }
	  
	  
	  
	
		public void  AfficheMain_pile() {
			
			
			try{
				
				String [] column= {"Nom","point","couleur"};
				String [] ligne = new String [3];
				
				DefaultTableModel model = new DefaultTableModel(null,column);
				
				Iterator<Carte> it = game.m.iterator();
				while(it.hasNext()) {
					
					Carte c = it.next();
					
					ligne [0] =c.getNomCarte() ;
					ligne [1] =String.valueOf(c.getPoint_Carte());
					ligne [2] =c.getCouleur().name() ;
					
					
				
					model.addRow(ligne);
				
				}
				
			    main.setModel(model);
					
			}catch(Exception e) { System.err.println(e);}
			
			
			
              try{
				
				String [] column= {"Nom","point","couleur"};
				String [] ligne = new String [3];
				
				DefaultTableModel model = new DefaultTableModel(null,column);
				
				Iterator<Carte> it = game.p.iterator();
				while(it.hasNext()) {
					
					Carte c = it.next();
					
					ligne [0] =c.getNomCarte() ;
					ligne [1] =String.valueOf(c.getPoint_Carte());
					ligne [2] =c.getCouleur().name() ;
					
					
				
					model.addRow(ligne);
				
				}
				
			pile.setModel(model);
					
			}catch(Exception e) { System.err.println(e);}
			
			
		}
		
			

		public void Oeuvre() {
			
			 try{
					
					String [] column= {"Nom","point","couleur"};
					String [] ligne = new String [3];
					
					DefaultTableModel model = new DefaultTableModel(null,column);
					
					Iterator<Carte> it = game.o.iterator();
					while(it.hasNext()) {
						
						Carte c = it.next();
						
						ligne [0] =c.getNomCarte() ;
						ligne [1] =String.valueOf(c.getPoint_Carte());
						ligne [2] =c.getCouleur().name() ;
						
						
					
						model.addRow(ligne);
					
					}
					
				oeuvre.setModel(model);
						
				}catch(Exception e) { System.err.println(e);}
					
		}
		
		
		
		public void Vie_future() {
			
			 try{
					
					String [] column= {"Nom","point","couleur"};
					String [] ligne = new String [3];
					
					DefaultTableModel model = new DefaultTableModel(null,column);
					
					Iterator<Carte> it = game.v.iterator();
					while(it.hasNext()) {
						
						Carte c = it.next();
						
						ligne [0] =c.getNomCarte() ;
						ligne [1] =String.valueOf(c.getPoint_Carte());
						ligne [2] =c.getCouleur().name() ;
						
						
					
						model.addRow(ligne);
					
					}
					
				vie_future.setModel(model);
						
				}catch(Exception e) { System.err.println(e);}
					
		}
		
		
		
		// 2nd joueur
		
		
public void  AfficheMain_pile1() {
			
			
			try{
				
				String [] column= {"Nom","point","couleur"};
				String [] ligne = new String [3];
				
				DefaultTableModel model = new DefaultTableModel(null,column);
				
				Iterator<Carte> it = game.m1.iterator();
				while(it.hasNext()) {
					
					Carte c = it.next();
					
					ligne [0] =c.getNomCarte() ;
					ligne [1] =String.valueOf(c.getPoint_Carte());
					ligne [2] =c.getCouleur().name() ;
					
					
				
					model.addRow(ligne);
				
				}
				
			    main.setModel(model);
					
			}catch(Exception e) { System.err.println(e);}
			
			
			
              try{
				
				String [] column= {"Nom","point","couleur"};
				String [] ligne = new String [3];
				
				DefaultTableModel model = new DefaultTableModel(null,column);
				
				Iterator<Carte> it = game.p1.iterator();
				while(it.hasNext()) {
					
					Carte c = it.next();
					
					ligne [0] =c.getNomCarte() ;
					ligne [1] =String.valueOf(c.getPoint_Carte());
					ligne [2] =c.getCouleur().name() ;
					
					
				
					model.addRow(ligne);
				
				}
				
			pile.setModel(model);
					
			}catch(Exception e) { System.err.println(e);}
			
			
		}
		
			

		public void Oeuvre1() {
			
			 try{
					
					String [] column= {"Nom","point","couleur"};
					String [] ligne = new String [3];
					
					DefaultTableModel model = new DefaultTableModel(null,column);
					
					Iterator<Carte> it = game.o1.iterator();
					while(it.hasNext()) {
						
						Carte c = it.next();
						
						ligne [0] =c.getNomCarte() ;
						ligne [1] =String.valueOf(c.getPoint_Carte());
						ligne [2] =c.getCouleur().name() ;
						
						
					
						model.addRow(ligne);
					
					}
					
				oeuvre.setModel(model);
						
				}catch(Exception e) { System.err.println(e);}
					
		}
		
		
		
		public void Vie_future1() {
			
			 try{
					
					String [] column= {"Nom","point","couleur"};
					String [] ligne = new String [3];
					
					DefaultTableModel model = new DefaultTableModel(null,column);
					
					Iterator<Carte> it = game.v1.iterator();
					while(it.hasNext()) {
						
						Carte c = it.next();
						
						ligne [0] =c.getNomCarte() ;
						ligne [1] =String.valueOf(c.getPoint_Carte());
						ligne [2] =c.getCouleur().name() ;
						
						
					
						model.addRow(ligne);
					
					}
					
				vie_future.setModel(model);
						
				}catch(Exception e) { System.err.println(e);}
					
		}
}