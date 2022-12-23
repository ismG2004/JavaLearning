package payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.model.Employee;

public interface EmployeesRepository extends JpaRepository<Employee, Integer> {

}
