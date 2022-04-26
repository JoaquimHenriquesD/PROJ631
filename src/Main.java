import java.util.ArrayList;
import java.util.Arrays;

import org.jgrapht.graph.*;

public class Main {
	
	public static void main(String[] args) {

		Graphe<NoeudSysteme, Edge> graphe1 = new Graphe <>(Edge.class);
		
		
		
		Donnees donnée1 = new Donnees(1,10);
		Donnees donnée2 = new Donnees(2,20);
		Donnees donnée3 = new Donnees(3,30);
		Donnees donnée4 = new Donnees(4,40);
		Donnees donnée5 = new Donnees(5,50);

		Donnees donnée6 = new Donnees(6,60);
		Donnees donnée7 = new Donnees(7,70);
		Donnees donnée8 = new Donnees(8,80);

		
		ArrayList<Donnees> listeDonnnées = new ArrayList<Donnees>();

		listeDonnnées.add(donnée1);
		listeDonnnées.add(donnée2);
		listeDonnnées.add(donnée3);
		listeDonnnées.add(donnée4);
		listeDonnnées.add(donnée5);


		graphe1.addDonneesAPlacer(listeDonnnées);
		
		
		NoeudSysteme noeud1 = new NoeudSysteme(1,50);
		NoeudSysteme noeud2 = new NoeudSysteme(2,70);
		NoeudSysteme noeud3 = new NoeudSysteme(3,80);
		NoeudSysteme noeud4 = new NoeudSysteme(4,40);




		noeud1.ajouterNoeudAccessible(noeud2);
		noeud1.ajouterNoeudAccessible(noeud3);
		noeud1.ajouterNoeudAccessible(noeud4);

		noeud2.ajouterNoeudAccessible(noeud1);
		noeud2.ajouterNoeudAccessible(noeud3);
		noeud2.ajouterNoeudAccessible(noeud4);

		noeud3.ajouterNoeudAccessible(noeud1);
		noeud3.ajouterNoeudAccessible(noeud2);
		noeud3.ajouterNoeudAccessible(noeud4);

		noeud4.ajouterNoeudAccessible(noeud1);
		noeud4.ajouterNoeudAccessible(noeud2);
		noeud4.ajouterNoeudAccessible(noeud3);



		graphe1.addNoeudGraphe(noeud1);
		graphe1.addNoeudGraphe(noeud2);
		graphe1.addNoeudGraphe(noeud3);
		graphe1.addNoeudGraphe(noeud4);


		ArrayList<Integer> listetest = new ArrayList<Integer>();

		listetest.add(donnée1.getIDdonnee());
		listetest.add(donnée2.getIDdonnee());
		listetest.add(donnée3.getIDdonnee());
		listetest.add(donnée4.getIDdonnee());
		listetest.add(donnée5.getIDdonnee());

		
		Utilisateurs util1 = new Utilisateurs(1,listetest,1);
		System.out.println(util1.getListeIdDonnees());

		graphe1.addUtil(util1);


		graphe1.addVertex(noeud1);
		graphe1.addVertex(noeud2);
		graphe1.addVertex(noeud3);
		graphe1.addVertex(noeud4);
				
		DefaultWeightedEdge edge1 = (DefaultWeightedEdge)graphe1.addEdge(noeud1, noeud2);
		DefaultWeightedEdge edge2 = (DefaultWeightedEdge)graphe1.addEdge(noeud1, noeud4);
		DefaultWeightedEdge edge3 = (DefaultWeightedEdge)graphe1.addEdge(noeud2, noeud3);
		DefaultWeightedEdge edge4 = (DefaultWeightedEdge)graphe1.addEdge(noeud4, noeud3);




		graphe1.setEdgeWeight(edge1, 1);
		graphe1.setEdgeWeight(edge2, 2);
		graphe1.setEdgeWeight(edge3, 3);
		graphe1.setEdgeWeight(edge4, 4);


		graphe1.placerDonneeGraphe(util1);

		graphe1.affichageNoeudGraphe();


		
		
		
		
		Graphe<NoeudSysteme, Edge> graphe2 = new Graphe <>(Edge.class);

		graphe2.addDonneesAPlacer(listeDonnnées);
		
		NoeudSysteme noeud11 = new NoeudSysteme(1,5);
		NoeudSysteme noeud22 = new NoeudSysteme(2,40);
		NoeudSysteme noeud33 = new NoeudSysteme(3,80);
		NoeudSysteme noeud44 = new NoeudSysteme(4,4);
		
		noeud11.ajouterNoeudAccessible(noeud22);
		noeud11.ajouterNoeudAccessible(noeud44);
		noeud11.ajouterNoeudAccessible(noeud33);

		noeud22.ajouterNoeudAccessible(noeud33);
		noeud22.ajouterNoeudAccessible(noeud11);
		noeud22.ajouterNoeudAccessible(noeud44);

		noeud44.ajouterNoeudAccessible(noeud33);
		noeud44.ajouterNoeudAccessible(noeud22);
		noeud44.ajouterNoeudAccessible(noeud11);
		
		Utilisateurs util10 = new Utilisateurs(1,listetest,1);
		Utilisateurs util11 = new Utilisateurs(2,listetest,2);

		graphe2.addVertex(noeud11);
		graphe2.addVertex(noeud22);
		graphe2.addVertex(noeud33);
		graphe2.addVertex(noeud44);

		graphe2.addNoeudGraphe(noeud11);
		graphe2.addNoeudGraphe(noeud22);
		graphe2.addNoeudGraphe(noeud33);
		graphe2.addNoeudGraphe(noeud44);



		graphe2.addEdge(noeud11, noeud22);
		graphe2.addEdge(noeud11, noeud44);
		graphe2.addEdge(noeud22, noeud33);
		graphe2.addEdge(noeud44, noeud33);


		graphe2.setEdgeWeight(edge1, 6);
		graphe2.setEdgeWeight(edge2, 8);
		graphe2.setEdgeWeight(edge3, 2);
		graphe2.setEdgeWeight(edge4, 10);
				
		System.out.println("");
		graphe2.placerDonnee2Utils(util10, util11, donnée2);
		graphe2.affichageNoeudGraphe();

			
	}
	
}

