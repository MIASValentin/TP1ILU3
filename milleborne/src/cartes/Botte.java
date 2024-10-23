package cartes;

public class Botte extends Probleme{
	
	public Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return type.getBotte();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Botte botte) {
			return type.equals(botte.type);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31*type.hashCode();
	}
}
