package jeu;

import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
	private MainJoueur main = new MainJoueur();
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur) {
			return nom.equals(nom);
		}
		return false;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
