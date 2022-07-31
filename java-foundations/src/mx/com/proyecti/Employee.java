package mx.com.proyecti;

import java.util.Date;

// El nombre de la clase siempre empieza con mayúscula (UpperCamelCase)
// Una clase es un modelo que defina una estructura con datos y métodos
// Un objeto es una instancia de una clase
// Para crear un nuevo objeto se usa la palabra reservada "new"

//POJO (Poor Old Java Object)
// Java Beans
	//- Atributos privados
	//- Métodos públicos
	//- Constructor sin argumentos
	// Me sirven para modelar entidades de negocio
public class Employee {
	//Datos
	//nombrados iniciando con minúscula (lowerCamelCase
	//Tipos de datos primitivis (int, boolean, float)
	//Tipos de datos no primitivos (String, Integer, Double)
	private int id;
	private String name;
	private String lastName;
	private double salary;
	private Date birthdate;
	
	//Métodos: empiezan con minúscula (lowerCamelCase)
	//getters: métodos que me van a permitir acceder a los datos (lectura)
	//setters: métodos que me van a permitir modificar los datos (escritura)

	public int getId() {
		return this.id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Employee(int id) {
		super();
		this.id = id;
	}
	
	public Employee() {
		super();
	}
	public Employee(int id, String name, String lastName, double salary, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.salary = salary;
		this.birthdate = birthdate;
	}
	
	public double calcBonus() {
		return this.getSalary() * GoodBonus.getBonusPercent(this);
	}
	
}
