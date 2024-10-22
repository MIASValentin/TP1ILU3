package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	private List<Limite> pileLimite = new ArrayList<>();
	private List<Bataille> pileBataille = new ArrayList<>();
	private List<Borne> collectionBorne = new ArrayList<>();
	
	public List<Limite> getPileLimite() {
		return pileLimite;
	}
	
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
	
	public List<Borne> getCollectionBorne() {
		return collectionBorne;
	}
	
	public int donnerLimitationVitesse() {
		int limite = 50;
		if(pileLimite.isEmpty() || pileLimite.get(pileLimite.size()-1) instanceof FinLimite) {
			limite = 200;
		}
		return limite;
	}
	
	public int donnerKmParcourus() {
        int totalKm = 0;
        
        for (Iterator<Borne> iterateur = collectionBorne.iterator(); iterateur.hasNext(); ) {
            Borne borne = iterateur.next();
            totalKm += borne.getKm();
        }
        
        return totalKm;
    }
	
	public boolean peutAvancer() {
        return !pileBataille.isEmpty() && pileBataille.get(pileBataille.size() - 1).equals(Cartes.FEU_VERT);
    }
	
	private boolean estDepotFeuVertAutorise() {
		if(pileBataille.isEmpty()) {
			return true;
		}
        Bataille sommet = pileBataille.get(pileBataille.size() - 1);
        return (sommet instanceof Attaque && sommet.getType() == Type.FEU) || !(sommet instanceof Parade && sommet.getType() == Type.FEU);
    }
	
	private boolean estDepotBorneAutorise(Borne borne) {
        return peutAvancer() && borne.getKm() <= donnerLimitationVitesse() && + borne.getKm() <= 1000;
    }
	
	 private boolean estDepotLimiteAutorise(Limite limite) {
		 if(pileLimite.isEmpty()) {
			 return limite instanceof DebutLimite;
		 }
		 Limite sommet = pileLimite.get(pileLimite.size() - 1);
		 if(limite instanceof DebutLimite) {
			 return sommet instanceof FinLimite;
		 }
		 else {
			 return sommet instanceof DebutLimite;
		 }
	 }
	 
	 private boolean estDepotBatailleAutorise(Bataille bataille) {
		 if(bataille instanceof Attaque) {
			 return peutAvancer();
		 }
		 if(bataille instanceof Parade parade) {
			 if(parade.getType() == Type.FEU) {
				 return estDepotFeuVertAutorise();
			 }
			 if(pileBataille.isEmpty()) {
				 return false;
			 }
			 Bataille sommet = pileBataille.get(pileBataille.size() - 1);
			 return (sommet instanceof Attaque && sommet.getType() == parade.getType());
		 }
		 return false;
	 }
	 
	 public boolean estDepotAutorise(Carte carte) {
		 if(carte instanceof Borne borne) {
			 return estDepotBorneAutorise(borne);
		 }
		 else if(carte instanceof Limite limite) {
			 return estDepotLimiteAutorise(limite);
		 }
		 else {
			 return estDepotBatailleAutorise((Bataille) carte);
		 }
	 }

	public void deposer(Carte carte) {
        if (carte instanceof Borne borne) {
            collectionBorne.add(borne);
        }
        
        if (carte instanceof DebutLimite || carte instanceof FinLimite) {
            pileLimite.add((Limite) carte);
        }
        
        if (carte instanceof Bataille bataille) {
            pileBataille.add(bataille);
        }
    }
	
}
