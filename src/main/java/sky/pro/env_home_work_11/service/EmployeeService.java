package sky.pro.env_home_work_11.service;

import org.springframework.stereotype.Service;
import sky.pro.env_home_work_11.domain.Employee;

import java.util.Collection;
import java.util.List;

@Service
public interface EmployeeService  {
    Employee getEmployee(Integer number);

    String addEmployee(Employee employees);

    String searchEmployee(Employee employee);

    String deleteEmployee(Integer id);

    List<Employee> getEmployeeList();

    Collection<Employee> findAll();
}
