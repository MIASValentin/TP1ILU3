package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	private Set<Joueur> joueurs = new HashSet<>();
	private static int NBCARTES = 6;
	
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCartes = new ArrayList<>();
		listeCartes.addAll(Arrays.asList(jeu.donnerCartes()));
		listeCartes = GestionCartes.melanger(listeCartes);
		Carte[] cartes = new Carte[listeCartes.size()];
		listeCartes.toArray(cartes) ;
		sabot = new Sabot(cartes);
	}
	
	public Sabot getSabot() {
		return sabot;
	}
	
	public void inscrire(Set<Joueur> joueurs) {
		this.joueurs.addAll(joueurs);
	}
	
	public void distribuerCartes() {
		for(int i = 0; i < NBCARTES; i++) {
			for(Joueur joueur : joueurs) {
				joueur.donner(sabot.piocher());
			}
		}
	}
}