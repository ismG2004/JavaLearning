package payroll;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import payroll.model.Employee;

import java.util.List;

public class EmployeeDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public EmployeeDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    public List<Employee> getAll() {
        return jdbcTemplate.query("SELECT * FROM Employee", new EmployeeMapper());
    }

    public Employee getById(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM Employee where id=?", new Object[]{id}, new EmployeeMapper()
                )
                .stream().findAny().orElse(null);
    }

    @Transactional
    public void insert(Employee employee) {
        jdbcTemplate.update(
                "INSERT INTO employee VALUES(nextval('table_name_id_seq'), ?, ?)",
                employee.getName(), employee.getSalary()
        );
    }

    @Transactional
    public void update(int id, Employee updatedEmployee) {
        jdbcTemplate.update(
                "UPDATE employee SET name=?, salary=? WHERE id=?",
                updatedEmployee.getName(), updatedEmployee.getSalary(), id
        );
    }

    @Transactional
    public void deleteEmployee(Employee e) {
        jdbcTemplate.update(
                "DELETE FROM employee where id=" + e.getId() + ""
        );
    }

//    public int saveEmployee(Employee e) {
//        String query = " insert into employee values( '" + e.getId() + e.getName() + e.getSalary() + "' ) ";
//        return jdbcTemplate.update(query);
//    }
//
//    public int updateEmployee(Employee e) {
//        String query
//                = "UPDATE employee SET name = '"+ e.getName() +"', salary='"+e.getSalary()+"' where id='"+e.getId()+"'  ";
//        return jdbcTemplate.update(query);
//    }
//
//    public int deleteEmployee(Employee e) {
//        String query
//                = "DELETE FROM employee where id="+ e.getId() +"";
//        return jdbcTemplate.update(query);
//    }
}