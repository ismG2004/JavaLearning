package payroll.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import payroll.dto.EmployeeDTO;
import payroll.model.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T16:57:30+0400",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDTO employeeToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setName( employee.getName() );
        employeeDTO.setSalary( employee.getSalary() );

        return employeeDTO;
    }

    @Override
    public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setName( employeeDTO.getName() );
        employee.setSalary( employeeDTO.getSalary() );

        return employee;
    }
}
