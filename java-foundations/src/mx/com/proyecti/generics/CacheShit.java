package mx.com.proyecti.generics;

public class CacheShit {
	private Shirt shirt;
	
	public void add(Shirt shirt) {
		this.shirt = shirt;
	}
	
	public Shirt get() {
		return this.shirt;
	}
}
