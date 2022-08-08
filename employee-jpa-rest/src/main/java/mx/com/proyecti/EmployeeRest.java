package mx.com.proyecti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Le indica a la plataforma que esta clase representa el punto de inicio
// de mi aplicación implementada con Spring Boot
//Spring Boot
@SpringBootApplication
public class EmployeeRest {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRest.class, args);

	}

}
