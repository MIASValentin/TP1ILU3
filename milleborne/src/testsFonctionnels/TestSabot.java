package testsFonctionnels;

import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
    public static void main(String[] args) {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] cartes = jeuDeCartes.getCartes();
        Carte[] cartes2 = jeuDeCartes.getCartes();
        Sabot<Carte> sabot = new Sabot<>(cartes);
        Sabot<Carte> sabot2 = new Sabot<>(cartes2);
        
        while (!sabot.estVide()) {
            Carte carte = sabot.piocher();
            System.out.println("Je pioche " + carte);
        }
        Iterator<Carte> iterateur = sabot2.iterator();
        
        while (iterateur.hasNext()) {
            Carte carte = iterateur.next();
            System.out.println("Je pioche " + carte);
            iterateur.remove();
        }
        
        Carte asDuVolant = new Botte(Type.ACCIDENT);
        try {
			sabot2.ajouterCarte(asDuVolant );
			
        } catch (IllegalStateException e) {
            System.out.println("Exception levée : " + e.getMessage());
        }
        
        try {
            sabot2.piocher();
        } catch (NoSuchElementException e) {
            System.out.println("Exception levée : " + e.getMessage());
        }
        System.out.println("OK");
    }
}
