package cartes;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes = {
			new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12),
			new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14),
			new Configuration(new FinLimite(), 6),
			new Configuration(new Parade(Type.ESSENCE), 6),
			new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6),
			new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new DebutLimite(), 4),
			new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3),
			new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1),
			new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1),
			new Configuration(new Botte(Type.ACCIDENT), 1),
	};
	
	private static class Configuration {
		private int nbExemplaires = 0;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}
		
		public Carte getCarte() {
			return carte;
		}
		
		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}
	
	public String affichageJeuDeCarte() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("JEU : \n \n");
		for(int i = 0; i < typesDeCartes.length; i++) {
			chaine.append(typesDeCartes[i].getNbExemplaires() + " ");
			chaine.append(typesDeCartes[i].getCarte() + "\n");
		}
		return chaine.toString();
	}

	public Carte[] donnerCartes() {
		int totalCartes = 0;
	    for (Configuration config : typesDeCartes) {
	        totalCartes += config.getNbExemplaires();
	    }

	    Carte[] tabCartes = new Carte[totalCartes];
	    
	    for (int i = 0,  j = 0; i < typesDeCartes.length; i++) {
			Configuration configuration = typesDeCartes[i];
	        for (int k = 0; k < configuration.getNbExemplaires(); k++, j++) {
	        	tabCartes[j] = configuration.getCarte();
	        }
	    }
	    
	    return tabCartes;
	}
	
	private int count(Carte carte, Carte[] cartes) {
		int nbCarte = 0;
		for(int i = 0; i < cartes.length; i++) {
			if(carte.equals(cartes[i]))
				nbCarte += 1;
		}
		return nbCarte;
	}
	
	public boolean checkCount() {
		boolean check = false;
		Carte[] tabCartes = donnerCartes();
		int indice = 0;
		for (Configuration configuration: typesDeCartes) {
			check = check && count(tabCartes[indice], tabCartes) == configuration.getNbExemplaires();
			indice+=configuration.getNbExemplaires();
		}
		return check;
	}
}
