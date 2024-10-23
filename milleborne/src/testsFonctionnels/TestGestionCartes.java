package testsFonctionnels;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {

	public static void main(String[] args) {
		List<Integer> liste = new ArrayList<>();
		liste.add(1);
		liste.add(1);
		liste.add(2);
		liste.add(1);
		liste.add(3);
		System.out.println(liste);
		System.out.println(GestionCartes.extraire(liste));
		System.out.println("Liste : " + liste);
		List<Integer> melanger =  GestionCartes.melanger(liste);
		System.out.println("Melanger :" +  liste + " -> " + melanger);
		System.out.println(GestionCartes.verifierMelange(liste, liste));
		List<Integer> rassemblement = GestionCartes.rassembler(melanger);
		System.out.println("Rassembler : " + GestionCartes.verifierRassemblement(rassemblement));
		
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
		listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste melangee sans erreur ? "
		+ GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblee sans erreur ? "
		+ GestionCartes.verifierRassemblement(listeCartes));
	}

}
