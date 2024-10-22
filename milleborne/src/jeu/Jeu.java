package jeu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	
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
}
