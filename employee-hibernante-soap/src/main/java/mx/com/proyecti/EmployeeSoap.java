package mx.com.proyecti;

import java.util.Date;
import java.util.List;

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
	
	@WebMethod
	public Long addEmployee(
			@WebParam(name="firstName") String firstName,
			@WebParam(name="lastName") String lastName,
			@WebParam(name="birthdate") Date birthdate,
			@WebParam(name="salary") Double salary,
			@WebParam(name="phone") String phone,
			@WebParam(name="email") String email
			) {
		return manager.addEmployee(firstName, lastName, birthdate, salary, phone, email);
	}
	
	@WebMethod
	public void updateEmployee(
			@WebParam(name="id")Long id, 
			@WebParam(name="salary") Double salary) {
		manager.updateEmployee(id, salary);
	}
	
	@WebMethod
	public void deleteEmployee(
			@WebParam (name="id")Long id) {
	 manager.deleteEmployee(id);	
	}
	
	@WebMethod
	public List<Employee> listEmployee(){
		return manager.listEmployees();
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
