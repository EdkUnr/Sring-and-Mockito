package com.department.homeworkmockito.controller;

import com.department.homeworkmockito.employee.Employee;
import com.department.homeworkmockito.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartmentId(@PathVariable int id) {
        return departmentService.getEmployeesByDepartmentId(id);
    }

    @GetMapping("/{id}/salary/sum")
    public double getSalarySumByDepartmentId(@PathVariable int id) {
        return departmentService.getSalarySumByDepartmentId(id);
    }

    @GetMapping("/{id}/salary/max")
    public double getMaxSalaryByDepartmentId(@PathVariable int id) {
        return departmentService.getMaxSalaryByDepartmentId(id);
    }

    @GetMapping("/{id}/salary/min")
    public double getMinSalaryByDepartmentId(@PathVariable int id) {
        return departmentService.getMinSalaryByDepartmentId(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return departmentService.getEmployeesGroupedByDepartment();
    }
}
