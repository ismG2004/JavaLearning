package payroll.repository;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payroll.model.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {
//Dto toDto(Entity entity);
}
