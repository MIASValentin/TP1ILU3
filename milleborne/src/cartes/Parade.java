package cartes;

public class Parade extends Bataille {
	
	public Parade(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return type.getParade();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Parade parade) {
			return type.equals(parade.type);
		}
		return false;
	}
}
