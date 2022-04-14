package sky.pro.env_home_work_11.service;

import sky.pro.env_home_work_11.domain.Employee;

import java.util.List;


public interface DepartmentService {

    List<Employee> getAll();

    String amount(Integer department);

    String maxSalary(Integer department);

    String minSalary(Integer department);

    List<Employee> getAllDepartment(Integer department);
}
