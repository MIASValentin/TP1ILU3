package jeu;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;

public class Coup {
	private Joueur joueurCourant;
	private Carte carteJouee;
	private Joueur joueurCiblee = null;
	
	public Coup(Joueur joueurCourant, Carte carteJouee, Joueur joueurCiblee) {
		this.joueurCourant = joueurCourant;
		this.carteJouee = carteJouee;
		this.joueurCiblee = joueurCiblee;
	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public Carte getCarteJouee() {
		return carteJouee;
	}

	public Joueur getJoueurCiblee() {
		return joueurCiblee;
	}
	
	public boolean estValide() {
		if(carteJouee instanceof Attaque || carteJouee instanceof DebutLimite) {
			if(joueurCiblee == null) {
				return true;
			}
			return joueurCiblee.estDepotAutorise(carteJouee);
		}
		return joueurCourant.estDepotAutorise(carteJouee);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coup coup) {
			return joueurCourant.equals(coup.joueurCourant) && carteJouee.equals(coup.carteJouee) && joueurCiblee.equals(coup.joueurCiblee);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31*(joueurCourant.hashCode() + carteJouee.hashCode() + joueurCiblee.hashCode());
	}
}
