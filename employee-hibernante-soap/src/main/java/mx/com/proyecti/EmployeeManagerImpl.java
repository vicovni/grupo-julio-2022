package mx.com.proyecti;

import java.util.Date;

import mx.com.proyecti.entity.Employee;

public class EmployeeManagerImpl {

	public static void main(String[] args) {
		EmployeeManager manager = new EmployeeManager();
		//Long id = manager.addEmployee(
		//		"Victor", "Calderon", new Date(), 8000, "5555555555", "vhcalderong@gmail.com");
		//System.out.println("El id generado es " + id);
		
		Employee emp = manager.getEmployee(1L);
		System.out.println("El nombre del empleado es " + emp.getFirstName() +  " " + emp.getLastName());
	}

}
