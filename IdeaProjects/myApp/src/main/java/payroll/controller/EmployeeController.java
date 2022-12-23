package payroll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import payroll.EmployeeDAO;
import payroll.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("employees", employeeDAO.getAll());
        return "employess/getAll";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("employees", employeeDAO.getById(id));
        return "employees/getById";
    }

    @GetMapping("/insert")
    public String insert(Model model) {
        model.addAttribute("employees", new Employee());
        return "employees/new";
    }

    @PostMapping()
    public String getById(@PathVariable("id") int id, Employee employee) {
        return "employees/getById";
    }
}
