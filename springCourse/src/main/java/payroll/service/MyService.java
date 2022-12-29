package payroll.service;

import org.springframework.stereotype.Service;

import payroll.dto.EmployeeDTO;
import payroll.exceptions.CustomException;
import payroll.mapper.EmployeeMapper;
import payroll.model.Employee;
import payroll.repository.EmployeesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyService {
    private EmployeesRepository employeesRepository;
    private EmployeeMapper employeeMapper;

    // Constructor Injection
    public MyService(EmployeesRepository employeesRepository, EmployeeMapper employeeMapper) {
        this.employeesRepository = employeesRepository;
        this.employeeMapper = employeeMapper;
    }

    // Get all
    public List<EmployeeDTO> getAllEmployees() {
        return employeesRepository
                .findAll()
                .stream()
                .map(employeeMapper::employeeToEmployeeDto)
                .collect(Collectors.toList());
    }

    // Get by ID
    public EmployeeDTO getEmployeesById(int id) {
        return employeesRepository
                .findById(id)
                .map(employeeMapper::employeeToEmployeeDto)
                .orElseThrow(
                        () -> new CustomException("getEmployeesById: Can't find employee")
                );

//        return employeesRepository.findById(id).get();
//        Optional<Employee> foundPersonOptional = employeesRepository.findById(id);
//         Exception handling
//         deprecated because of the orElseThrow()
//        if (check(foundPersonOptional)) {
//            employee = foundPersonOptional.get();
//        }
//
//        return employeeMapper.employeeToEmployeeDto(employee);
    }

    public void deleteEmployeeById(int id) {
        Employee employee = employeesRepository.findById(id).orElseThrow(
                () -> new CustomException("deleteUserById: Can't find exception")
        );
        employeesRepository.deleteById(employee.getId());
    }

    public void insertEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        employeesRepository.save(employee);
    }

    public void updateEmployee(EmployeeDTO employeeDTO, int id) {
        Employee employee = employeesRepository.findById(id).get();

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());

        employeesRepository.save(employee); // write an update service method
    }

    public void deleteAll() {
        employeesRepository.deleteAll();
    }
    // because of the .orElseThrow method i dont need check() method after that
//    private boolean check(Optional<Employee> optional) {
//        if (optional.isEmpty()) throw new CustomException("Custom error");
//        else {
//            return true;
//        }
//    }

//    //     Convert Data -> DTO
//     /* NOW CODE IS REPLACED WITH MAPSTRUCT GENERATED CODE
//        LOOK FOR EmployeeMapperImpl
//        [27.12.2022] */
//    private EmployeeDTO convertDataToDTO(Employee employeeUserData) {
//
//        EmployeeDTO dto = new EmployeeDTO();
//
//        dto.setName(employeeUserData.getName());
//        dto.setSalary(employeeUserData.getSalary());
//
//        return dto;
//    }
}
