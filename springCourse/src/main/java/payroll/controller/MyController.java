package payroll.controller;

import org.springframework.web.bind.annotation.*;

import payroll.dto.EmployeeDTO;
import payroll.service.MyService;

import java.util.List;

@RestController
public class MyController {
    private MyService myService;

    // Constructor Injection
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/employees/get")
    public List<EmployeeDTO> getAllEmployees() {
        return myService.getAllEmployees();
    }

    @GetMapping("/employees/get/{id}")
    public EmployeeDTO getById(@PathVariable("id") int id) {
        return myService.getEmployeesById(id);
    }

    @PostMapping("/employees/create")
    public void insertUser(@RequestBody EmployeeDTO employeeDTO) {
        myService.insertEmployee(employeeDTO);
    }

    @PatchMapping("/employees/update/{id}")
    public void updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") int id) {
        myService.updateEmployee(employeeDTO, id);
    }

    @DeleteMapping("/employees/delete/{id}")
    public void deleteEmployeeById(@PathVariable("id") int id) {
        myService.deleteEmployeeById(id);
    }

    @DeleteMapping("/employees/delete/all")
    public void deleteAll() {
        myService.deleteAll();
    }
//    @GetMapping("/employees/get/{id}")
//    private EmployeeDTO getEmployeesById(@PathVariable("id") int id) {
////        return mappingService.getEmployeesById();
//    }
}
