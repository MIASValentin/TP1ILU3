package testsFonctionnels;

import cartes.Carte;
import jeu.Jeu;

public class TestJeu {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		Carte[] cartes = jeu.getSabot().getCartes();
		for(int i = 0; i < cartes.length;i++) {
			System.out.println(cartes[i]);
		}
	}

}
