package mx.com.proyecti;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import mx.com.proyecti.entity.Employee;

public class EmployeeManager {
	
	private SessionFactory factory; //Se crea al inicio, implementa el patrón singleton
	
	public EmployeeManager() {
		factory = new Configuration().configure().buildSessionFactory();
	}
	
	public Long addEmployee(String firstName, String lastName, Date birthdate,
			double salary, String phone, String email) { //SQL INSERT
		Session session = factory.openSession(); //El objeto sesión se crea cada que quiera ejecutar
												// una instrucción a mi base de datos
		Transaction tx = null;// Inicia un bloque de transacción, si existe algún error puedo llamar
								// a rollback. Si todo está OK llamo a commit
		Long id = null;
		try {
			tx = session.beginTransaction();
			Employee employee = new Employee(firstName, lastName, birthdate, salary, phone, email);
			session.persist(employee);
			session.flush();
			tx.commit();
			id = employee.getId();			
		}catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}

		return id;
	}
	
	public Employee getEmployee(Long id) { //SQL SELECT
		Session session = factory.openSession();
		Employee employee = null;
		try {
			employee = session.get(Employee.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employee;
	}
	
	public List<Employee> listEmployees( ){ //SQL SELECT *
		Session session = factory.openSession();
		Transaction tx = null;
		List<Employee> employees = null;

		try {
			tx = session.beginTransaction();
			employees = session.createQuery("FROM Employee", Employee.class).getResultList(); //Ejecuta una consulta en HQL
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return employees;
	}

	/* Method to UPDATE salary for an employee */
	public void updateEmployee(long id, double salary ){ //SQL UPDATE
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, id); 
			employee.setSalary(salary);
			session.persist(employee); ///upsert
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

	/* Method to DELETE an employee from the records */
	public void deleteEmployee(long id){ /// SQL DELETE
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, id); 
			session.remove(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
	}

	

}
