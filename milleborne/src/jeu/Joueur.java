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
	
	public Carte prendreCarte(Sabot sabot) {
		Carte cartePiocher = null;
		if(!sabot.estVide()) {
			cartePiocher = sabot.piocher();
		}
		return cartePiocher;
	}
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte carte) {
        zoneDeJeu.deposer(carte);
    }
	
	public boolean estDepotAutorise(Carte carte) {
		return zoneDeJeu.estDepotAutorise(carte);
	}
}
