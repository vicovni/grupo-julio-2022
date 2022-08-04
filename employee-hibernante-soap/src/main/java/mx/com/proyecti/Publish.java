package mx.com.proyecti;

import javax.xml.ws.Endpoint;

public class Publish {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:8081/employee-hibernate-soap", new EmployeeSoap());
		System.out.println("Servidor iniciado en el puerto 8081");

	}

}
