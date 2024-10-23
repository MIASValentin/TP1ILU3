package jeu;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import cartes.Botte;
import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
	private MainJoueur main = new MainJoueur();
	private Random random = new Random();
	
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
	
	public Set<Coup> coupsPossible(Set<Joueur> participants) {
		Set<Coup> coups = new HashSet<>();
		Coup coup = null;
		for(Joueur participant : participants) {
			for(int i = 0; i < main.nbCartes();i++) {
				coup = new Coup(this,main.getCarte(i),participant);
				if(coup.estValide()) {
					coups.add(coup);
				}
			}
		}
		return coups;
	}
	
	public Set<Coup> coupsDefausse() {
		Set<Coup> coups = new HashSet<>();
		Coup coup = null;
		for(int i = 0; i < main.nbCartes();i++) {
			coup = new Coup(this,main.getCarte(i),null);
			if(coup.estValide()) {
				coups.add(coup);
			}
		}
		return coups;
	}
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}
	
	public Coup choisirCoup(Set<Joueur> participants) {
		Set<Coup> coupsPossibles = coupsPossible(participants);
		int index;
		if(!coupsPossibles.isEmpty()) {
			index = random.nextInt(0,coupsPossibles.size());
		}
		else {
			coupsPossibles = coupsDefausse();
			index = random.nextInt(0,coupsPossibles.size());
		}
		Coup[] coups = null;
		coups = coupsPossibles.toArray(coups);
		return coups[index];
	}
	
	public String afficherEtatJoueur() {
		StringBuilder chaine = new StringBuilder();
		Set<Botte> bottes = zoneDeJeu.getBottes();
		chaine.append("Bottes : ");
		for(Botte botte : bottes) {
			chaine.append(botte + " ");
		}
		chaine.append("\nLimitation de vitesse : " + (zoneDeJeu.donnerLimitationVitesse() == 50));
		chaine.append("Sommet Pile : " + );
		return chaine.toString();
	}
}
