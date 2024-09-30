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
		GestionCartes gestion = new GestionCartes();
		System.out.println(gestion.extraire(liste));
		
	}

}
