package mx.com.proyecti.generics;

public class CacheAny <T> {
	private T dato;
	
	public void add(T dato) {
		this.dato = dato;
	}
	
	public T get() {
		return this.dato;
	}
	
}
