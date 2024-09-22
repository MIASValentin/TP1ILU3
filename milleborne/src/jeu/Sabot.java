package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;


public class Sabot<E extends Carte> implements Iterable<E> {
    private E[] cartes;
    private int nbCartes;
    private int nombreOperation = 0;

    public Sabot(E... cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
    }

    public boolean estVide() {
        return nbCartes == 0;
    }

    public void ajouterCarte(E carte) {
        if (nbCartes >= cartes.length - 1) {
            throw new IllegalStateException("Capacité maximum atteinte !");
        }
        cartes[nbCartes] = carte;
        nbCartes++;
        nombreOperation++;
    }

    public Carte piocher() {
        if (estVide()) {
            throw new NoSuchElementException("Le sabot est vide !");
        }
        Carte carte = cartes[0];
        for (int i = 1; i < nbCartes; i++) {
            cartes[i - 1] = cartes[i];
        }
        nbCartes--;
        nombreOperation++;
        return carte;
    }

    @Override
    public Iterator<E> iterator() {
        return new SabotIterator();
    }

    private class SabotIterator implements Iterator<E> {
        private int indiceIterateur = 0;
        private boolean nextEffectue = false;
        private int nombreOperationsReference = nombreOperation;

        @Override
        public boolean hasNext() {
            return indiceIterateur < nbCartes;
        }

        @Override
        public E next() {
        	verificationConcurrence();
            if (hasNext()) {
            	E carte = cartes[indiceIterateur];
            	indiceIterateur++;
            	nextEffectue = true;
            	return carte;
            }
            else {
                throw new NoSuchElementException("Pas de carte suivante !");
            }
        }

        @Override
        public void remove() {
        	verificationConcurrence();
        	if(nbCartes < 1 || !nextEffectue) {
        		throw new IllegalStateException();
        	}
        	for(int i = indiceIterateur - 1; i<nbCartes - 1;i++) {
        		cartes[i] = cartes[i+1];
        	}
        	nextEffectue = false;
        	indiceIterateur--;
        	nbCartes--;
        	nombreOperation++;
        	nombreOperationsReference++;
        }
        
        private void verificationConcurrence() {
        	if (nombreOperationsReference != nombreOperation) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
