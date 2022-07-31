package mx.com.proyecti.generics;

public class GenericsImpl {

	public static void main(String[] args) {
		CacheString myMessage = new CacheString();
		CacheShit myShirt = new CacheShit();
		
		//Genéricos
		CacheAny<String> myGenericMessage = new CacheAny<>();
		CacheAny<Shirt> myGenericShirt = new CacheAny<>();
		
		myMessage.add("Save this for me");
		myGenericMessage.add("Save this generic message for me");
		myGenericShirt.add(new Shirt());

	}

}
