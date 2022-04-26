import java.util.ArrayList;

public class Utilisateurs {
	private int idUtil;
	private ArrayList<Integer> listeIdDonnees = new ArrayList<Integer>();
	private int noeudAccessible;
	
	
	public Utilisateurs(int idUtil, ArrayList<Integer> listeIdDonnees, int noeudAccessible) {
		this.idUtil = idUtil;
		this.listeIdDonnees = listeIdDonnees;
		this.noeudAccessible = noeudAccessible;
	}


	public int getIdUtil() {
		return idUtil;
	}


	public void setIdUtil(int idUtil) {
		this.idUtil = idUtil;
	}


	public ArrayList<Integer> getListeIdDonnees() {
		return listeIdDonnees;
	}


	public void setListeIdDonnees(ArrayList<Integer> listeIdDonnees) {
		this.listeIdDonnees = listeIdDonnees;
	}


	public int getNoeudAccessible() {
		return noeudAccessible;
	}


	public void setNoeudAccessible(int noeudAccessible) {
		this.noeudAccessible = noeudAccessible;
	}
	
	
	
	
 	
}
