//package payroll.service;
//
//import org.springframework.stereotype.Service;
//import payroll.model.Employee;
//import payroll.repository.EmployeesRepository;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class EmployeesService {
//
//    private final EmployeesRepository employeesRepository;
//
//    public EmployeesService(EmployeesRepository employeesRepository) {
//        this.employeesRepository = employeesRepository;
//    }
//
//    public List<Employee> getAllEmployees() {
//        List<Employee> employees = new ArrayList<>();
//
//        employeesRepository.findAll().forEach(employees1 -> employees.add(employees1)); //1st way
//        employeesRepository.findAll().forEach(employees::add); //2nd way
//        employees.addAll(employeesRepository.findAll()); //3rd way
//
//        return employees;
//    }
//
//    public Employee getEmployeesById(int id) {
//        return employeesRepository.findById(id).get();
//    }
//
//    public void save(Employee employees) {
//        Employee employee = new Employee();
//        employee.setName(dto.getname);
//        employee.setSalary(dto.getsalary);
//        employeesRepository.save(employees);
//        employeesRepository.save(employees);
//        employeesRepository.save(employees);
//    }
//
//    public void update(Employee employees, float id) {
//        Employee updatedEmployee = employeesRepository.findById(id).get();
//        updatedEmployee.setSalary(dto.getSalary);
//        updatedEmployee.setName(dto.getname);
//        employeesRepository.save(employees);
//        employeesRepository.save(employees);
//    }
//
//    public void delete(int id) {
//        employeesRepository.deleteById(id);
//    }
//}
