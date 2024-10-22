package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes<E> {
	private static Random random = new Random();;
	
	public static <E> E extraire(List<E> liste ) {
		int index = random.nextInt(0, liste.size());
		return liste.remove(index);
	}
	
	public E extraireIterateur(List<E> liste) {
	    int index = random.nextInt(0, liste.size());
	    Iterator<E> iterateur = liste.iterator();
	    E element = null;

	    for (int i = 0; i <= index && iterateur.hasNext(); i++) {
	        element = iterateur.next();
	    }

	    iterateur.remove();

	    return element;
	}
	
	public static <E> List<E> melanger(List<E> liste ) {
		List<E> listeMelange = new ArrayList<>();
		int index;
		while(!liste.isEmpty()) {
			index = random.nextInt(0,liste.size());
			listeMelange.add(liste.remove(index));
		}
		return listeMelange;
	}
	
    public static <E> boolean verifierMelange(List<E> liste1, List<E> liste2) {
        if (liste1.size() != liste2.size()) {
            return false;
        }
        for (E element : liste1) {
            if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
                return false;
            }
        }
        return true;
    }
	
    public static <E> List<E> rassembler(List<E> liste) {
        List<E> listeResultat = new ArrayList<>();
        List<E> elementsVisites = new ArrayList<>();

        for (Iterator<E> iterateur = liste.iterator(); iterateur.hasNext(); ) {
            E element = iterateur.next();
            if (!elementsVisites.contains(element)) {
                for (E elem : liste) {
                    if (elem.equals(element)) {
                        listeResultat.add(elem);
                    }
                }
                elementsVisites.add(element);
            }
        }

        return listeResultat;
    }
	
    public static <E> boolean verifierRassemblement(List<E> liste) {
        if (liste.isEmpty() || liste.size() == 1) {
            return true;
        }

        E elementCourant = liste.get(0);

        for (ListIterator<E> premierIterateur = liste.listIterator(1); premierIterateur.hasNext(); ) {
            E prochainElement = premierIterateur.next();

            if (!prochainElement.equals(elementCourant)) {
                for (ListIterator<E> deuxiemeIterateur = premierIterateur; deuxiemeIterateur.hasNext(); ) {
                    E elementSuivant = deuxiemeIterateur.next();
                    if (elementSuivant.equals(elementCourant)) {
                        return false;
                    }
                }
                elementCourant = prochainElement;
            }
        }

        return true;
    }

}
