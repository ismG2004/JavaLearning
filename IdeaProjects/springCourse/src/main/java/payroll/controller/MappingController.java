package payroll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import payroll.dto.EmployeeDTO;
import payroll.service.MappingService;

import java.util.List;

@RestController
public class MappingController {
    private MappingService mappingService;

    // Constructor Injection
    public MappingController(MappingService mappingService) {
        this.mappingService = mappingService;
    }

    @GetMapping("/employees/get")
    public List<EmployeeDTO> getAllEmployees() {
        return mappingService.getAllEmployees();
    }

    @GetMapping("/employees/get/{id}")
    private EmployeeDTO getEmployeesById(@PathVariable("id") int id) {
        return mappingService.getEmployeesById();
    }
}
