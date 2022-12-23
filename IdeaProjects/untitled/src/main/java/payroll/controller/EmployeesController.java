package payroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import payroll.model.Employee;
import payroll.service.EmployeesService;

import java.util.List;

@Controller
public class EmployeesController {

    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }


//    EmployeesService employeesService;
//
//    @GetMapping("/employees")
//    private List<Employee> getAllEmployees() {
//        return employeesService.getAllEmployees();
//    }
//
//    @GetMapping("/employees/{id}")
//    private Employee getEmployeesById(@PathVariable("id") int id) {
//        return employeesService.getEmployeesById(id);
//    }
//
//    @PostMapping("/employees")
//    private int saveEmployee(@RequestBody Employee employees) {
//        employeesService.saveOrUpdate(employees);
//        return employees.getId();
//    }
//
//    @PutMapping("/employees")
//    private Employee update(@RequestBody Employee employees) {
//        employeesService.saveOrUpdate(employees);
//        return employees;
//    }
//
//    @DeleteMapping("/employees/{id}")
//    private void deleteEmployees(@PathVariable("id") int id) {
//        employeesService.delete(id);
//    }


//    EmployeesController(EmployeesRepository repository) {
//        this.repository = repository;
//    }
//
//    @GetMapping("/employees")
//    List<Employee> all() {
//        return repository.findAll();
//    }
//
//    @PostMapping("/employees")
//    Employee newEmployee(@RequestBody Employee newEmployee) {
//        return repository.save(newEmployee);
//    }
}
