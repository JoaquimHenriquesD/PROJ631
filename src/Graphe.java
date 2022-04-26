import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.*;

public class Graphe<Noeud,Edge> extends SimpleWeightedGraph {
	private ArrayList<Utilisateurs> listeUtillisateur = new ArrayList<Utilisateurs>();
	private ArrayList<Donnees> listeDonneesAPlacer = new ArrayList<Donnees>();
	private ArrayList<Donnees> listeDonneesPlacees = new ArrayList<Donnees>();
	private ArrayList<NoeudSysteme> listeNoeud = new ArrayList<NoeudSysteme>();

	
	public Graphe(Class arg0) {
		super(arg0);
	}
	
	
	
	public List cheminLePlusCourt(NoeudSysteme noeud1,NoeudSysteme noeud2) {
		DijkstraShortestPath<NoeudSysteme,Edge> dij = new DijkstraShortestPath<NoeudSysteme,Edge> (this, noeud1, noeud2);
		System.out.println(dij.findPathBetween(this, noeud1, noeud2));
		return dij.findPathBetween(this, noeud1, noeud2);
	}
	
	
	public void addUtils(ArrayList<Utilisateurs> utils) {
		for(int i = 0;i<utils.size();i++) {
			this.addVertex(utils);
		}
	}
	
	public void addUtil(Utilisateurs util) {

		this.listeUtillisateur.add(util);
	}
	
	
	public void addNoeud(ArrayList<NoeudSysteme> noeud) {
		for(int i = 0;i<noeud.size();i++) {
			this.addVertex(noeud);
			this.listeNoeud.add(noeud.get(i));
		}
	}
	
	
	public void addDonneesAPlacer(ArrayList<Donnees> don) {
		for(int i = 0;i<don.size();i++) {
			this.listeDonneesAPlacer.add(don.get(i));
		}
	}
	
	
	public void donneesAEtePlace(Donnees don) {
		this.listeDonneesAPlacer.remove(don);
		this.listeDonneesPlacees.add(don);
	}
	
	
	public Donnees getDonneeById(Integer id) {
		for(int i = 0;i<this.listeDonneesAPlacer.size();i++) {
			if(this.listeDonneesAPlacer.get(i).getIDdonnee() == id) {
				return this.listeDonneesAPlacer.get(i);
			}
		}
		return null;
	}
	
	
	public ArrayList<Donnees> getDonneesAPlacerParUtil(Utilisateurs util){
		ArrayList<Donnees> arr = new ArrayList<Donnees>();
		for(int i = 0;i<util.getListeIdDonnees().size();i++) {
			if(util.getListeIdDonnees().get(i) == this.listeDonneesAPlacer.get(i).getIDdonnee()) {
				arr.add(this.listeDonneesAPlacer.get(i));
			}
		}
		return arr;
	}
	
	
	public void addNoeudGraphe(NoeudSysteme noeud) {

		this.listeNoeud.add(noeud);
	}
	
	
	
	public void addPlusieursNoeuds(ArrayList<NoeudSysteme> noeuds) {
		for(int i = 0;i<noeuds.size();i++) {
			this.listeNoeud.add(noeuds.get(i));
		}
	}
	
	
	public NoeudSysteme getNoeudById(int idNoeud) {
		for(int i = 0;i<this.listeNoeud.size();i++) {
			if (this.listeNoeud.get(i).getIdNoeud() == idNoeud){
				return this.listeNoeud.get(i);
			}
		}
		System.out.println("Le noeud cherche n'est pas dans le graphe");
		return null;
	}
	
	public void placerDonneesPourChaqueUtil() {
		for(int i = 0;i<this.listeUtillisateur.size();i++) {
			this.placerDonneeGraphe(this.listeUtillisateur.get(i));
		}
	}
	

	public void placerDonneeGraphe(Utilisateurs util) {

		ArrayList<Donnees> aPlacer = new ArrayList<Donnees>();


			aPlacer = this.getDonneesAPlacerParUtil(util);

			NoeudSysteme noeudDeLUtil = this.getNoeudById(util.getNoeudAccessible());

			for (Donnees j : aPlacer) {
				if (  noeudDeLUtil.getCapacite() >= j.getTaille()) {
					noeudDeLUtil.ajouterDonnée(j);

				}else {

					ArrayList<NoeudSysteme> noeudAccessibles = noeudDeLUtil.getNoeudAccessibles();
					double initIndice = 1000;
					NoeudSysteme nchoisie = noeudAccessibles.get(0);
					for(NoeudSysteme noeud : noeudAccessibles) {
						if (this.getEdgeWeight(this.getEdge(noeudDeLUtil,noeud))< initIndice & noeud.getCapacite()>= j.getTaille()) {
							initIndice = this.getEdgeWeight(this.getEdge(noeudDeLUtil,noeud));
							nchoisie = noeud;
						}
					}
					nchoisie.ajouterDonnée(j);
				}
		}
	}

	
	public void placerDonnee2Utils(Utilisateurs util1,Utilisateurs util2,Donnees donnee) {

		ArrayList<Edge> listeDePoids = (ArrayList) this.cheminLePlusCourt(this.getNoeudById(util1.getNoeudAccessible()),this.getNoeudById(util2.getNoeudAccessible()));
		System.out.println(listeDePoids.toString());
			int indice = listeDePoids.size()/2;
			String noeud = listeDePoids.get(indice).toString().charAt(1)+"";
			int idNoeud = Integer.parseInt(noeud);

			if(this.getNoeudById(idNoeud).getCapacite() >= donnee.getTaille()) {
				this.getNoeudById(idNoeud).ajouterDonnée(donnee);
			}else {
				noeud = listeDePoids.get(indice).toString().charAt(5)+"";
				idNoeud = Integer.parseInt(noeud);
				if(this.getNoeudById(idNoeud).getCapacite() >= donnee.getTaille()) {
					this.getNoeudById(idNoeud).ajouterDonnée(donnee);
				}
			}
	}
	
	
	public void affichageNoeudGraphe() {
		for(NoeudSysteme n : this.listeNoeud) {
			System.out.println("Noeud : " + n.getIdNoeud() + " capacite : "+n.getCapacite() + " donnees placees : "+n.getListeDonneesStockees());
		}
	}
	

}
