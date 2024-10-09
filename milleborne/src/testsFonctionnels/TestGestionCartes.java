package testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import utils.GestionCartes;

public class TestGestionCartes {

	public static void main(String[] args) {
		List<Integer> liste = new ArrayList<>();
		liste.add(1);
		liste.add(1);
		liste.add(2);
		liste.add(1);
		liste.add(3);
		GestionCartes<Integer> gestion = new GestionCartes<Integer>();
		System.out.println(gestion.extraire(liste));
		System.out.println("Liste : " + liste);
		List<Integer> melanger =  gestion.melanger(liste);
		System.out.println("Melanger :" +  melanger + " -> " + liste);
		System.out.println(gestion.verifierMelange(liste, liste));
		List<Integer> rassemblement = gestion.rassembler(melanger);
		System.out.println("Rassembler : " + gestion.verifierRassemblement(rassemblement));
	}

}
