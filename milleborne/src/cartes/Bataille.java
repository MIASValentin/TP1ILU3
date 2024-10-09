package cartes;

public abstract class Bataille extends Carte {
	protected Type type;
	
	protected Bataille(Type type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Attaque attaque) {
			return type.equals(attaque.type);
		}
		return false;
	}

}
