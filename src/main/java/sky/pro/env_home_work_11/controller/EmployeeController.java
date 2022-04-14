package sky.pro.env_home_work_11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.env_home_work_11.domain.Employee;
import sky.pro.env_home_work_11.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/list")
    public List<Employee> printEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping(path = "/employee")
    public Employee employeeS(@RequestParam("number") Integer number) {
        return employeeService.getEmployee(number);
    }

    @GetMapping(path = "/employee/add")
    public String employeeAdd(@RequestParam String firstname, @RequestParam String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeService.addEmployee(employee);
    }

    @GetMapping(path = "/employee/search")
    public String employeeSearch(@RequestParam String firstname, @RequestParam String lastname) {
        Employee employee = new Employee(firstname, lastname);
        return employeeService.searchEmployee(employee);
    }

    @GetMapping(path = "/employee/delete")
    public String employeeDel(@RequestParam Integer id) {
        return employeeService.deleteEmployee(id);
    }
}
