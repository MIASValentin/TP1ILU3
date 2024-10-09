package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GestionCartes<E> {
	
	public E extraire(List<E> liste ) {
		Random random = new Random();
		int index = random.nextInt(0, liste.size());
		return liste.remove(index);
	}
	
	public List<E> melanger(List<E> liste ) {
		List<E> listeMelange = new ArrayList<>();
		for(Iterator<E> iterateur = liste.listIterator();iterateur.hasNext();iterateur.next()) {
			
		}
		return listeMelange;
	}
	
	public boolean verifierMelange(List<E> listeOrigine, List<E> listeMelange) {
		return false;
	}
	
	public List<E> rassembler(List<E> liste) {
		for(Iterator<E> constructionListe = liste.listIterator();constructionListe.hasNext();constructionListe.next()) {

		}
		return liste;
	}
	
	public boolean verifierRassemblement(List<E> liste) {
		return true;
	}
}
