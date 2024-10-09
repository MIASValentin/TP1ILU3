package cartes;

public abstract class Probleme extends Carte {
	protected Type type;

	protected Probleme(Type type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Botte botte) {
			return type.equals(botte.type);
		}
		return false;
	}
}
