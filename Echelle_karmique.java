package Karmaka;

public enum Echelle_karmique {
	
/**
	 * Enumeration representant l'echelle Karmique
	 * @author Richanel Mbou
    * @version 1.0
	 */
	
	
	Serpent(4),Loup(5),Singe(6),Transcendence(7);
	
	int point_Karmique;

	Echelle_karmique(int point_Karmique) {
		// TODO Auto-generated constructor stub
	
      	this.point_Karmique=point_Karmique;
	
	
	}
	
	public int getPoint_Karmique() {
		
		return point_Karmique;
	}
	
	
	
	
	
	

}
