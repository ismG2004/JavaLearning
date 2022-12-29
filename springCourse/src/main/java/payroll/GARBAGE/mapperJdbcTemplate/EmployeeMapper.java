//package payroll;
//
//import org.springframework.jdbc.core.RowMapper;
//import payroll.model.Employee;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
// /* EmployeeMapper for jdbcTemplate */
//public class EmployeeMapper implements RowMapper<Employee> {
//    @Override
//    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Employee employee = new Employee();
//
//        employee.setId(rs.getInt("id"));
//        employee.setName(rs.getString("name"));
//        employee.setSalary(rs.getInt("salary"));
//
//        return employee;
//    }
//}