package payroll.service;

import org.springframework.stereotype.Service;

import payroll.dto.EmployeeDTO;
import payroll.model.Employee;
import payroll.repository.EmployeesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingService {
    private EmployeesRepository employeesRepository;

    // Constructor Injection
    public MappingService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    // Get all
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeesRepository.findAll().forEach(employee -> employees.add(employee));

        return employeesRepository
                .findAll()
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }

    // Get by ID
    public Employee getEmployeesById(int id) {
        return employeesRepository.findById(id).get();
    }

    // Convert Data -> DTO
    private EmployeeDTO convertDataIntoDTO(Employee employeeUserData) {

        EmployeeDTO dto = new EmployeeDTO();
        dto.setName(employeeUserData.getName());
        dto.setSalary(employeeUserData.getSalary());

        return dto;
    }
}
