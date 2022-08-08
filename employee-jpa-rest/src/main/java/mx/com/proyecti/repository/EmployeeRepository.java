package mx.com.proyecti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.proyecti.entity.Employee;
//JpaRepository pertenece a Spring Data JPA
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
