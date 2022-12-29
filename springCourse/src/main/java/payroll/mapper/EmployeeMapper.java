package payroll.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import payroll.dto.EmployeeDTO;
import payroll.model.Employee;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO employeeToEmployeeDto(Employee employee);

    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}