package mx.com.proyecti;

import java.util.Date;

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
	

}
