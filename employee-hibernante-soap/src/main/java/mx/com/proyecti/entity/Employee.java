package mx.com.proyecti.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//Anotación es metadata que le incluye funcionalidad extra a mi código
//Inicia con el símbolo de @
//Se puede anteponer a clases, atributos, métodos, argumentos de entrada
@Entity //Inicar que la clase corresponde al modelo de una tabla dentro de 
		// una base de datos
@Table(name="employee") //Indica el nombre de la tabla que corresponde
						//a la entidad que estoy definiendo
public class Employee {
	@Id //indico cuál será el id único dentro de mis atributos
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name="employee_generator", sequenceName="EMPLOYEE_SEQUENCE", allocationSize = 1)
	private long id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private double salary;
	private String phone;
	private String email;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, Date birthdate, double salary, String phone,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.salary = salary;
		this.phone = phone;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
