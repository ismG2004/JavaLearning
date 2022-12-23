//package payroll;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import payroll.model.Employee;
//
//import java.util.List;
//@SpringBootApplication
//public class SpringBootRestApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(SpringBootRestApplication.class, args);
//
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml"
//        );
//
//        EmployeeDAO dao = context.getBean("employeeDAO", EmployeeDAO.class);
//
////        Employee employee1 = new Employee("Ismayil", 999);
////        dao.save(employee1);
//
////        dao.insert();
////        dao.update(1, new Employee("Murad", 666));
//
//        List<Employee> listEmployee = dao.getAll();
//        for (Employee record : listEmployee) {
//            System.out.print("ID : " + record.getId());
//            System.out.print(", Name : " + record.getName());
//            System.out.println(", Salary : " + record.getSalary());
//        }
//
//        context.close();
//    }
//}

package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }
}
