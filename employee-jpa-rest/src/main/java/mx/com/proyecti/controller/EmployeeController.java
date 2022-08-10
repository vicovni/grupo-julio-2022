package mx.com.proyecti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/employees")	//HTTP POST
	Long insertEmployee(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}
	
	//http://localhost:8090/employees/2
	@GetMapping("/employees/{id}")	//HTTP GET
	Employee getEmployee(@PathVariable Long id) { //@PathVariable relaciona el valor de entrada del método con el valor definido en getMapping {id}
		return employeeService.getEmployee(id);
	}
	
	@PutMapping("/employees") //HTTP PUT
	Boolean updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees/{id}") //HTTP DELETE
	Boolean deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
	
}
