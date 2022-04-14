package sky.pro.env_home_work_11.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work_11.domain.Employee;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getAll() {
        return employeeService.getEmployeeList();
    }

    @Override
    public String amount(Integer department) {
        int costAmount = 0;
        double averageSalary = 0;
        final Integer sum = employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department).mapToInt(e -> e.getSalary()).sum();
        final Integer count = Math.toIntExact(employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department).count());
        costAmount = sum * 30;
        averageSalary = sum / count;
        return "Сумма затрат на зарплаты в месяц: " + costAmount +
                "р. : Среднее значение зарплат: " + averageSalary + "р. в отделе № " + department;
    }

    @Override
    public String maxSalary(Integer department) {
        final Optional<Employee> maxSalary = employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary));
        return "Сотрудник с максимальной зарплатой: " + maxSalary + "р.";
    }

    @Override
    public String minSalary(Integer department) {
        final Optional<Employee> minSalary = employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary));
        return "Сотрудник с минимальной зарплатой: " + minSalary + "р.";
    }

    @Override
    public List<Employee> getAllDepartment(Integer department) {
        final List<Employee> allDepartments = employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department).
                collect(Collectors.toList());
        return allDepartments;
    }
}