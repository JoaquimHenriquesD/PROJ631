import java.util.ArrayList;

public class NoeudSysteme implements Noeud {
	
	private int idNoeudSyst;
	private int capacite;
	private ArrayList<Integer> listeDonneesStockees = new ArrayList<Integer>();
	private ArrayList<NoeudSysteme> noeudAccessibles = new ArrayList<NoeudSysteme>();
	
	
	public ArrayList<Integer> getListeDonneesStockees() {

		return listeDonneesStockees;
	}

	
	public void ajouterNoeudAccessible(NoeudSysteme noeud) {

		this.noeudAccessibles.add(noeud);
	}

	public void setListeDonneesStockees(ArrayList<Integer> listeDonneesStockees) {
		this.listeDonneesStockees = listeDonneesStockees;
	}


	public NoeudSysteme(int idNoeudSyst, int capacite) {
		this.idNoeudSyst = idNoeudSyst;
		this.capacite = capacite;
	}
	
	
	public String toString() {

		return this.idNoeudSyst+"";
	}
	
	
	public void ajouterDonnée(Donnees donnee) {
		this.listeDonneesStockees.add(donnee.getIDdonnee());
		this.capacite = this.capacite - donnee.getTaille() ;
	}

	
	public int getCapacite() {

		return this.capacite;
	}

	public ArrayList<NoeudSysteme> getNoeudAccessibles() {

		return noeudAccessibles;
	}


	public void setNoeudAccessibles(ArrayList<NoeudSysteme> noeudAccessibles) {

		this.noeudAccessibles = noeudAccessibles;
	}


	@Override
	public int getIdNoeud() {
		// TODO Auto-generated method stub
		return this.idNoeudSyst;
	}
}
