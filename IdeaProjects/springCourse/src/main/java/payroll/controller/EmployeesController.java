//package payroll.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import payroll.model.Employee;
//import payroll.service.EmployeesService;
//
//import java.util.List;
//
//@RestController
//public class EmployeesController {
//
////    @GetMapping("/hello-world")
////    public String sayHello() {
////        return "hello-world";
////    }
//
//    private final EmployeesService employeesService;
//
//    public EmployeesController(EmployeesService employeesService) {
//        this.employeesService = employeesService;
//    }
//
//    @GetMapping("/employees")
//    private List<Employee> getAllEmployees() {
//        return employeesService.getAllEmployees();
//    }
//
//    @GetMapping("/employees/get/{id}")
//    private Employee getEmployeesById(@PathVariable("id") int id) {
//        return employeesService.getEmployeesById(id);
//    }
//
//    @PostMapping("/employees/save")
//    private Employee saveEmployee(@RequestBody Employee employees) {
//        employeesService.save(employees);
//        return employees;
//    }
//
//    @PatchMapping("/employees/update/{id}")
//    private Employee update(@RequestBody Employee employees, @PathVariable int id) {
//        employeesService.update(employees, id);
//        return employees;
//    }
//
//    @DeleteMapping("/employees/delete/{id}")
//    private void deleteEmployees(@PathVariable("id") int id) {
//        employeesService.delete(id);
//    }
//
//
//
////    EmployeesController(EmployeesRepository repository) {
////        this.repository = repository;
////    }
////
////    @GetMapping("/employees")
////    List<Employee> all() {
////        return repository.findAll();
////    }
////
////    @PostMapping("/employees")
////    Employee newEmployee(@RequestBody Employee newEmployee) {
////        return repository.save(newEmployee);
////    }
//}
