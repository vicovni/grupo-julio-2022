package mx.com.proyecti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.proyecti.entity.Employee;
import mx.com.proyecti.service.EmployeeService;

//Spring MVC
@RestController //Le indica a Spring que esta clase representa
				//la capa controladora
				//Expone las operaciones de mi servicio web REST
@RequestMapping("api") //Define la ruta raíz de mi endpoint
						//http://localhost:8090/api
public class EmployeeController {
	
	//Spring Core
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees") //HTTP GET
								//http://localhost:8090/api/employees
	List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
}
