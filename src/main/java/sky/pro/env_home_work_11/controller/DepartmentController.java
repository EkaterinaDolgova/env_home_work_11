package sky.pro.env_home_work_11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.env_home_work_11.domain.Employee;
import sky.pro.env_home_work_11.service.DepartmentService;
import java.util.List;
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping("/department/all")
    public List<Employee> printList() {
        return departmentService.getAll();
    }
    @GetMapping(path = "/department/department-amount")
    public String departmentamount(@RequestParam Integer department) {
        return departmentService.amount(department);
    }
    @GetMapping(path = "/department/max-salary")
    public String departmentMaxSalary(@RequestParam Integer department) {
        return departmentService.maxSalary(department);
    }
    @GetMapping(path = "/department/min-salary")
    public String departmentMinSalary(@RequestParam Integer department) {
        return departmentService.minSalary(department);
    }
    @GetMapping(path = "/department/all/d")
    public List<Employee> departmentAll(@RequestParam Integer department) {
        return departmentService.getAllDepartment(department);
    }
}
