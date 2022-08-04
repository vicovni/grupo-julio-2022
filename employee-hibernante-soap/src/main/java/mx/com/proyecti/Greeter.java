package mx.com.proyecti;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Greeter {
	public final String worldGreeting = "Hello World";
	
	public Greeter() {
		
	}
	
	@WebMethod
	public String greetWorld(@WebParam(name="nombre") String name) {
		return worldGreeting + " " + name;
	}

}
