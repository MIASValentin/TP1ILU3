package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	
	private List<Carte> cartesJoueur = new ArrayList<>();
	
	
	public void prendre(Carte carte) {
		cartesJoueur.add(carte);
	}
	
	public void jouer(Carte carte) {
		assert cartesJoueur.contains(carte);
		cartesJoueur.remove(carte);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for(Carte carte:cartesJoueur) {
			string.append(carte + " ");
		}
		return string.toString();
	}

}
