package payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payroll.model.Employee;
import payroll.repository.EmployeesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesService {

    EmployeesRepository employeesRepository;

    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeesRepository.findAll().forEach(employees1 -> employees.add(employees1));
        return employees;
    }

    public Employee getEmployeesById(int id) {
        return employeesRepository.findById(id).get();
    }

    public void saveOrUpdate(Employee employees) {
        employeesRepository.save(employees);
    }

    public void delete(int id) {
        employeesRepository.deleteById(id);
    }

    public void update(Employee employees, int id) {
        employeesRepository.save(employees);
    }
}
