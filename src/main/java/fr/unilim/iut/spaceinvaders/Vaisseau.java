package fr.unilim.iut.spaceinvaders;

public class Vaisseau {

	int x;
	int y;
	int longueur;
	int hauteur;
	Position origine;
	Dimension dimension;

	public Vaisseau(int longueur, int hauteur) {
		this(longueur, hauteur, 0, 0);
	}
	
	 public Vaisseau(int longueur, int hauteur, int x, int y) {
		   this.dimension = new Dimension(longueur, hauteur);
		   this.origine=new Position(x,y);
	    }

	 public boolean occupeLaPosition(int x, int y) {
	     if (estAbscisseCouverte(x) && estOrdonneeCouverte(y))
			return true;
		
	     return false;
     }

	private boolean estOrdonneeCouverte(int y) {
		return ordonneLaPlusBasse(y) && ordonneeLaPlusHaute(y);
	}

	private boolean ordonneeLaPlusHaute(int y) {
		return y<=this.origine.ordonnee();
	}

	private boolean ordonneLaPlusBasse(int y) {
		return this.origine.ordonnee()-this.dimension.hauteur()+1<=y;
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	public int abscisseLaPlusADroite() {
		return abscisseLaPlusAGauche()+this.dimension.longueur()-1;
	}
	 
	 
    public void seDeplacerVersLaDroite() {
    	this.origine.changerAbscisse(this.origine.abscisse()+1);
 }
	public int abscisse() {
        return abscisseLaPlusAGauche();
	}
    public void seDeplacerVersLaGauche() {
    	this.origine.changerAbscisse(this.origine.abscisse()-1);
	      
}

	public void positionner(int x, int y) {
		this.origine.changerAbscisse(x);
		  this.origine.changerOrdonnee(y);
		
	}
  


}
