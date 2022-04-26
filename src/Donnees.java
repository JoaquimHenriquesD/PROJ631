
public class Donnees {
	private int IDdonnee;
	private int taille;
	
	
	
	public Donnees(int iDdonnee, int taille) {
		IDdonnee = iDdonnee;
		this.taille = taille;
	}



	public int getIDdonnee() {

		return IDdonnee;
	}



	public void setIDdonnee(int iDdonnee) {

		IDdonnee = iDdonnee;
	}



	public int getTaille() {

		return taille;
	}



	public void setTaille(int taille) {

		this.taille = taille;
	}

	public String toString() {

		return "Donnees : "+this.IDdonnee + " taille : "+this.getTaille();
	}
	
	
}
