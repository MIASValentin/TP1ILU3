package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {

	public static void main(String[] args) {
		Borne borne1 = new Borne(25);
		Borne borne2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? " + borne1.equals(borne2) );
		Attaque feuR1 = new Attaque(Type.FEU);
		Attaque feuR2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouges sont identiques ? " + feuR1.equals(feuR2) );
		Parade feuV = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + feuR1.equals(feuV) );
	}

}
