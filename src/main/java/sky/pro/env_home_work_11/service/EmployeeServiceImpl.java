package sky.pro.env_home_work_11.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work_11.domain.Employee;
import sky.pro.env_home_work_11.exception.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Integer, Employee> employees;
    private Integer nextId = 0;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        employees.put(getNextId(), new Employee("Иван", "Иванов", 5, 50000));
        employees.put(getNextId(), new Employee("Петр", "Петров", 5, 54000));
        employees.put(getNextId(), new Employee("Владимир", "Иванченко", 1, 100000));
        employees.put(getNextId(), new Employee("Степан", "Казанцев", 1, 140000));
    }


    private Integer getNextId() {
        Integer result = nextId;
        nextId = nextId + 1;
        return result;
    }

    @Override
    public java.util.List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>(employees.values());
        return employeeList;
    }

    @Override
    public Employee getEmployee(Integer number) {
        if (employees.containsKey(number)) {
            return employees.get(number);
        }
        throw new EmployeeNotFoundException("Под данным номером нет сотрудника");
    }

    @Override
    public String addEmployee(Employee employee) {
        if (employees.containsValue(employee)) {
            return "Данный сотрудник есть в базе данных";
        }
        employees.put(getNextId(), employee);
        return employee.toString();
    }

    @Override
    public String searchEmployee(Employee employee) {
        if (employees.containsValue(employee)) {
            return "Данный сотрудник найден";
        }
        throw new EmployeeNotFoundException("Ошибка, сотрудник не найден");
    }

    @Override
    public String deleteEmployee(Integer id) {
        if (employees.containsKey(id)) {
            employees.remove(id);
            return " Данный сотрудник удален";

        }
        throw new EmployeeNotFoundException("Ошибка, сотрудника не найден");
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
