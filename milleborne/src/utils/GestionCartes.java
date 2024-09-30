package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestionCartes {
	
	public <E> E extraire(List<E> liste ) {
		Random random = new Random();
		int index = random.nextInt(0, liste.size()-1);
		return liste.remove(index);
	}
	
	public <E> List<E> melanger(List<E> liste ) {
		List<E> listeMelange = new ArrayList<>();
		for(int i = 0; i < liste.size();i++) {
			listeMelange.add(extraire(liste));
		}
		return listeMelange;
	}
}
