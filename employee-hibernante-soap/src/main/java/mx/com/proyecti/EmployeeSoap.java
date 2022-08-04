package mx.com.proyecti;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import mx.com.proyecti.entity.Employee;

@WebService //Inicializa una clase para que se comporte como un servicio web SOAP
public class EmployeeSoap {

	private EmployeeManager manager;
	
	public EmployeeSoap() {
		manager = new EmployeeManager();
	}
	
	//Operación
	@WebMethod
	public Employee readEmployee(@WebParam(name="id") Long id) {
		return manager.getEmployee(id);
	}
	
	//TODO: 
	//Generen los métos restantes:
	//createEmployee(firstName, lastName...)
	//updateEmployee(Long id, firstName, lastName)
	//deleteEmployee(Long id)
	//readAllEmployees()
	//Anteponer a cada método la anotación @WebMethod
	//Probar todas las operaciones en SOAPUI
	
}
